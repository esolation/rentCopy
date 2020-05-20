<#import "main_template.ftl" as t>
<@t.header>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</@t.header>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-2" style="height: 300px;">
            <a href="/createOrder"><div class="btn btn-success">Добавить авто</div></a>
            <ul class="nav nav-pills nav-stacked mt-3">
                <li class="nav-item">
                    <a class="nav-link active" href="/admin/processing">Заказы для рассмотрения</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/active">Активные заказы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/complete">Завершенные заказы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/awaitingPayments">Ожидают оплаты</a>
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
                        <td>${request.getOrder().getUser()[0].getUsername()}</td>
                        <td>${request.getDateOfCreating().getTime()?date}</td>
                        <td>${request.getRentalDate().getTime()?date}</td>
                        <td class="last"><a href="processing/active/${request.getId()}"><button class="btn btn-success"><i class="fas fa-check"></i></button></a>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter">
                                <i class="fas fa-times"></i>
                            </button>
                        </td>
                    </tr>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Отказ аренды</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                                <form action="/admin/processing/reject/${request.getId()}" method="post">
                                 <div>
                                <div class="modal-body">

                                        <div class="form-group">
                                            <label for="RejectMessage">Причина отказа</label>
                                            <textarea class="form-control" id="RejectMessage" name="message" rows="3"></textarea>
                                        </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                    <button type="submit" class="btn btn-primary">Отправить</button>
                                </div>
                            </div>
                                </form>
                        </div>
                    </div>
                </#list>



                </tbody>
            </table>




        </div>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="../static/js/admin_page.js"></script>
</body>
</html>