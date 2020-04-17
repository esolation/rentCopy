<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container">
    <div class="row">
        <div class="col-md-12">
<table class="table table-dark">
    <thead>
    <tr>

        <th scope="col">Номер заказа</th>
        <th scope="col">Автомобиль</th>
        <th scope="col">Кто заказал</th>
        <th scope="col">Дата заказа</th>
        <th scope="col">Дата окончания</th>
    </tr>
    </thead>
    <tbody>
    <#list requests as request>
        <tr>

            <th scope="row">${request.getId()}</th>
            <td><a href="/order/${request.getOrder().getId()}"> ${request.getOrder().getCarModel()}</a></td>
            <td>${request.getOrder().getUser().getUsername()}</td>
            <td>${request.getDateOfCreating()}</td>
            <td>${request.getDateOfCreating()}</td>
        </tr>
    </#list>
    </tbody>
</table>


        </div>
    </div>
</div>
</body>
</html>