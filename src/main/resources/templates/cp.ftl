<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container" xmlns="http://www.w3.org/1999/html">
<div class="row overflow-auto">
    <#if user??>

        <#list user.getOrder() as order>

                <div class="col-md-4">
                    <div class="card mb-3 mt-3" style="width: 18rem;">
                        <img class="card-img-top mw-50 mh-50" src="/img/${order.getPhotos()[0]}"  alt="${order.getCarModel()}">
                        <div class="card-body">
                            <h5 class="card-title">${order.getCarModel()}</h5>
                            Год: <p class="card-text badge badge-danger"> ${order.getYear()}</p></br>
                            Объем: <p class="card-text badge badge-danger"> ${order.getCapacity()}</p></br>
                            Расход: <p class="card-text badge badge-danger"> ${order.getConsumption()} л.</p></br>
                            Цена: <span class="card-text mx-auto badge badge-warning"> ${order.getCost()}</span></br></br>
                            <p>
                            <form action="/cp/request/${order.getId()}" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button class="btn btn-primary p-1" >Оформить заказ<a href="/cp/" class=""></a></button>
                            </form>
                            <form action="/cp/remove/${order.getId()}" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <button class="btn btn-danger p-1">Удалить заказ</button>
                            </form>
                            </p>
                        </div>
                    </div>
                </div>

        </#list>
        <#else>
        <p>У вас нет активных заказов!</p>
    </#if>
</div>
</div>
</body>
</html>