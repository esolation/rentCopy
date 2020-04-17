<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container">
    <div class="row overflow-auto">
        <#if orders?has_content>
    <#list orders as order>
        <#if order.isActive()>
        <div class="col-md-4">
    <div class="card mb-3 mt-3" style="width: 18rem;">
        <img class="card-img-top" src="/img/${order.getPhotos()[0]}"  alt="${order.getCarModel()}" height="200" >
        <div class="card-body">
            <h5 class="card-title">${order.getCarModel()}</h5>
            <p class="card-text badge badge-danger">Год: ${order.getYear()}</p>
            <p class="card-text badge badge-danger">Объем: ${order.getCapacity()}</p>
            <p class="card-text badge badge-danger">Расход: ${order.getConsumption()} л.</p>
            <a href="/order/${order.getId()}" class="btn btn-primary">Подробнее</a>
            <span class="card-text ml-5 badge badge-warning">Цена: ${order.getCost()}</span>
        </div>
    </div>
        </div>

        </#if>
    </#list>
        <#else>
            <p>Свободных машин нет.</p>
        </#if>


    </div>
</div>
</body>
</html>