<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-2 " style="height: 300px;">
            <ul class="nav nav-pills nav-stacked">
                <li class="nav-item">
                    <a class="nav-link" href="/admin/active">Активные заказы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/complete">Завершенные заказы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Ожидают оплаты</a>
                </li>

            </ul>
        </div>
        <div class="col-md-10">


            <table class="table table-dark">
                <thead id="table">
                <tr>

                    <th scope="col">Номер заказа</th>
                    <th scope="col">Автомобиль</th>
                    <th scope="col">Кто заказал</th>
                    <th scope="col">Дата заказа</th>
                    <th scope="col">Дата окончания</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <#list requests as request>
                    <tr>

                        <th scope="row">${request.getId()}</th>
                        <td><a href="/order/${request.getOrder().getId()}"> ${request.getOrder().getCarModel()}</a></td>
                        <td>${request.getOrder().getUser().getUsername()}</td>
                        <td>${request.getDateOfCreating().getTime()?date}</td>
                        <td>${request.getRentalDate().getTime()?date}</td>

                </#list>
                </tbody>
            </table>




        </div>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="js/admin_page.js"></script>
</body>
</html>