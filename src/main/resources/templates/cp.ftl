<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container mt-3" xmlns="http://www.w3.org/1999/html">
<div class="row overflow-auto">
    <div class="col-md-12">
    <#if user.getOrder()[0]?has_content && user.getOrder()[0].isActive()>
    <table class="table">
        <thead class="thead-dark">

        <tr>

            <th scope="col">Автомобиль</th>
            <th scope="col"></th>
            <th scope="col">Цена в сутки</th>
            <th scope="col">Дней аренды</th>
            <th scope="col">Общая цена</th>
            <th scope="col"></th>

        </tr>
        </thead>
        <#list user.getOrder() as order>
            <#if order.isActive()>

        <tbody>

        <tr>
           <td  colspan="2" > <img class="mt-3 ml-1" style="width: 100px;" src="/img/${order.getPhotos()[0]}" alt=""> <a href="/order/${order.getId()}"> <span class="ml-5">${order.getCarModel()}</span></a></td>
            <td  class="align-middle"> <span  class="alert alert-primary" role="alert">${order.getCost()}</span> </td>
            <form action="/cp/request/${order.getId()}" method="post">
            <td class="align-middle"><div class="form-group">
                <select name="orderDays" class="form-control" id="${order.getId()?js_string}">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>

                </div></td>


                <td class="align-middle">
                    <div  class="">


                        <span class="alert alert-danger" id="${order.getId() + "cost"}" role="alert">${order.getCost()}</span>
                    </div>
                </td>
                <td class="align-middle">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <#assign totalSum = 50>
                    <script>

                        <#--console.log(selectItem);-->
                        $("#${order.getId()}").change(function () {

                            var factor = $("#${order.getId()} option:selected").text();
                            var total = factor * ${order.getCost()};

                            $("#${order.getId()}cost").text(total);
                            $("#${order.getId()}total").attr("value",total);

                        })
                    </script>
                    <input type="hidden" name="totalCost" id="${order.getId()}total" value="${totalSum}">

                <button type="submit" class="btn btn-success">Заказать</button>
        </form>

                <form action="/cp/remove/${order.getId()}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-danger mt-1">Удалить</button>
                </form>
            </td>
        </tr>
        </tbody>
            </#if>
        </#list>


    </table>
        <#else>
            <div class="alert alert-info" role="alert">
                Корзина пуста
            </div>
    </#if>

    </div>

</div>
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

</body>
</html>