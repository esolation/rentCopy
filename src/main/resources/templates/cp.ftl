<#import "main_template.ftl" as t>
<@t.header>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</@t.header>
<div class="container mt-3" xmlns="http://www.w3.org/1999/html">
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
    <div class="col-md-12">
    <#if user.getOrder()[0]?has_content && user.getOrder()[0].isAvaliable()>
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
            <#if order.isAvaliable()>

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
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
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
                            var carCost = "${order.getCost()}".replace(/\s/g, '');
                            var total = factor * carCost ;
                            console.log("${order.getCost()}".replace(/\s/g, ''));
                            $("#${order.getId()}cost").text(total);
                            $("#${order.getId()}total").attr("value",total);

                        })
                    </script>
                    <input type="hidden" name="totalCost" id="${order.getId()}total" value="">

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