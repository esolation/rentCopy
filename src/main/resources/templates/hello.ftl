<#import "main_template.ftl" as t>
<#import "parts/page.ftl" as p>
<@t.header></@t.header>

<div class="container">

    <div class="row overflow-auto">
        <#if page.content?has_content>
    <#list page.content as order>
        <#if order.isAvaliable()>
        <div class="col-md-4">
    <div class="card mb-3 mt-3" style="width: 18rem;">
        <img class="card-img-top" src="/img/${order.getPhotos()[0]}"  alt="${order.getCarModel()}" height="200" >
        <div class="card-body">
            <h5 class="card-title">${order.getCarModel()}</h5>
            <p class="card-text badge badge-danger">Год: ${order.getYear()}</p>
            <p class="card-text badge badge-danger">Объем: ${order.getCapacity()}</p>
            <p class="card-text badge badge-danger">Расход: ${order.getConsumption()} л.</p>
            <a href="/order/${order.getId()}" class="btn btn-info">Подробнее</a>
            <span class="card-text ml-3 badge badge-warning">Цена: ${order.getCost()}</span> BYN
        </div>
    </div>
        </div>

        </#if>
    </#list>

        </#if>


    </div>
    <div class="d-flex justify-content-center"><@p.pager url page /></div>
</div>
</body>
</html>