<#import "main_template.ftl" as t>
<@t.header>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</@t.header>
<div class="p-2 mt-3" xmlns="http://www.w3.org/1999/html">
<div class="row overflow-auto">
    <#if processed??>
        <button type="button" id="processedModalButton" style="visibility: hidden"  class="btn btn-primary" data-toggle="modal" data-target="#processedModal">
            Launch demo modal
        </button>
        <div class="modal fade" id="processedModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Автомобиль готов к заказу</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Вы успешно оплатили заказ. Ваша заявка находится на рассмотрении администратора.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>

                    </div>
                </div>
            </div>
        </div>
    </#if>
    <div class="col-xl-12">
    <#if user.getOrder()[0]?has_content && user.getOrder()[0].isAvaliable()>
    <table class="table">
        <thead class="thead-dark">
        <tr>

            <th scope="col">Автомобиль</th>
            <th scope="col"></th>
            <th scope="col">Цена в сутки</th>
            <th scope="col">Начало аренды</th>
            <th scope="col">Конец аренды</th>
            <th scope="col">Общая сумма/скидка</th>
            <th scope="col"></th>



        </tr>

        </thead>
        <#list user.getOrder() as order>
            <#if order.isAvaliable()>

        <tbody>

        <tr>
           <td  colspan="2" > <img class="mt-3 ml-1" style="width: 100px;" src="/img/${order.getPhotos()[0]}" alt=""> <a href="/order/${order.getId()}"> <span class="ml-5">${order.getCarModel()}</span></a></td>
            <td  class="align-middle"> <span  class="alert alert-primary" role="alert">${order.getCost()}</span> </td>
            <form action="/cp/request/${order.getId()}" method="post">
            <td class="align-middle">
                <div class="alert alert-info" role="alert"><input value="" id="${order.getId()?js_string}beginRent" type="date"  name="dateOfBeginning"></div>
               </td>


                <td class="align-middle">
                    <div class="alert alert-info" role="alert"><input value="" id="${order.getId()?js_string}endRent" type="date"  name="dateOfEnding"></div>
                </td>
                <td class="align-middle">
                <input type="hidden" name="_csrf" value="${_csrf.token}">

                    <script>
                        $(document).ready(function () {
                            var today = new Date();
                            var tomorrow = new Date();
                            tomorrow.setDate(tomorrow.getDate()+1);
                            $('#${order.getId()}beginRent').val(today.toISOString().substr(0, 10));
                            $('#${order.getId()}endRent').val(tomorrow.toISOString().substr(0, 10));

                            $('#${order.getId()}endRent').change(function () {
                                var startDay = new Date($('#${order.getId()}beginRent').val());
                                var endDay = new Date($('#${order.getId()}endRent').val());
                                var millisBetween = startDay.getTime() - endDay.getTime();
                                var days = millisBetween / (1000 * 3600 * 24);
                                var result = Math.round(Math.abs(days));
                                var discount = 0;
                                if(result <= 7 ){
                                    discount = 0;
                                    $('#${order.getId()}totalCost').text(result * ${order.getCost()});
                                    //$('#discount').text(discount.toString());
                                }
                                else if(result <= 14 ){
                                    discount = 2;
                                    $('#${order.getId()}totalCost').text(result * ${order.getCost()} * 0.98);
                                    $('#${order.getId()}discount').text(discount.toString());
                                }
                                else if(result <= 21 ){
                                    discount = 5;
                                    $('#${order.getId()}totalCost').text(result * ${order.getCost()} * 0.95);
                                    $('#${order.getId()}discount').text(discount.toString());
                                }
                                else {
                                    discount = 10;
                                    $('#${order.getId()}totalCost').text(result * ${order.getCost()} * 0.9);
                                    $('#${order.getId()}discount').text(discount.toString());
                                }
                            })


                        })


                    </script>
                    <span class="alert alert-info" role="alert" id="${order.getId()?js_string}totalCost">${order.getCost()}</span>
                    <span>/</span>
                    <span id="${order.getId()?js_string}discount" class="alert alert-warning" role="alert">0</span>
                </td>
                <td>
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
</div>
<script src="../../js/cp.js"></script>
</body>
</html>