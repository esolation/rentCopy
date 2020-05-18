<#import "main_template.ftl" as t>
<@t.header>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</@t.header>
<div class="container mt-3" xmlns="http://www.w3.org/1999/html">

    <div class="row mt-5">
        <div class="col-md-12">
            <#if requests[0]?has_content>
                <table class="table">
                    <thead>
                    <tr>

                        <th scope="col">Номер заказа</th>
                        <th scope="col">Автомобиль</th>
                        <th scope="col">Начало аренды</th>
                        <th scope="col">Конец аренды</th>
                        <th scope="col">Статус</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list requests as request>
                        <tr>

                            <td>${request.getId()}</td>
                            <td>${request.getOrder().getCarModel()}</td>
                            <td>${request.getDateOfCreating().getTime()?date}</td>
                            <td>${request.getRentalDate().getTime()?date}</td>
                            <td><#if request.getRequestStatus()=="OPEN">
                                    <span class="badge badge-primary">Одобрен</span>
                                <#elseif request.getRequestStatus()=="AWAITING_PROCESSING">
                                    <button  type="button" class="btn  btn-warning processing" data-toggle="popover" title="Обработка заказа" data-content="Вы успешно отплатили заказ. После рассмотрения вашей заявки администратором вы сможете забрать автомобиль">Обрабатывается</button>
                                <#elseif request.getRequestStatus()=="REJECTED">
                                    <div>
                                        <button style="float: left;" type="button" class="btn btn-sm btn-danger" data-toggle="popover" title="Причина отказа" data-content="${request.getMessage()}. Деньги возвращены на Ваш баланс.">Отклонено</button>
                                        <span>
                                           <form class="form-horizontal ml-2" action="/cp/request/deleteRejected/${request.getId()}" method="post">
                                               <input type="hidden" name="_csrf" value="${_csrf.token}">
                                               <button type="submit" class="btn btn-sm btn-danger ml-2"><i class="fas fa-window-close"></i></button>
                                           </form>
                                           </span>
                                    </div>
                                <#else>
                                    <div>
                                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#${request.getId()}">
                                            Требуется оплата
                                        </button>
                                        <div class="modal fade" id="${request.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLongTitle">Причина</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="alert alert-danger" role="alert">
                                                            ${request.getMessage()}
                                                        </div>
                                                        Цена: <span class="badge badge-danger">${request.getRepairCost()}</span> р.

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                                                        <form action="/cp/request/complete/${request.getId()}" method="post">
                                                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                                                            <button type="submit" class="btn btn-primary">Оплатить</button>
                                                        </form>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>



                                </#if></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            <#else>
                <div class="alert alert-info" role="alert">
                    Активных или ожидающих оплаты заказов нет
                </div>
            </#if>
        </div>
    </div>







</div>
<script src="../../js/cp.js"></script>
<link rel="stylesheet" href="../static/css/my-orders.css">
</body>
</html>