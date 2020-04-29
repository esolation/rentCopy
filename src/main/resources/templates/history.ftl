<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container mt-3" xmlns="http://www.w3.org/1999/html">

    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead>
                <tr>

                    <th scope="col">Номер заказа</th>
                    <th scope="col">Автомобиль</th>
                    <th scope="col">Начало аренды</th>
                    <th scope="col">Конец аренды</th>
                    <th scope="col">Статус аренды</th>
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
                                <span class="badge badge-primary">Активен</span>
                            <#elseif request.getRequestStatus() =="AWAITING_PAYMENT">
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


                            <#else>
                                <span class="badge badge-success">Завершен</span>
                            </#if></td>
                    </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>







</div>

</body>
</html>