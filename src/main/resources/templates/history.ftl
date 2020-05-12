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
                        <td>
                            <#if request.getRequestStatus() =="REJECTED_HISTORY">
                                <span class="badge badge-danger">Отклонен</span>

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