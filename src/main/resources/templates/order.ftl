<#import "main_template.ftl" as t>
<@t.header></@t.header>

<div class="container mt-5">
    <#if model??>
        <button type="button" id="orderModalButton" style="visibility: hidden"  class="btn btn-primary" data-toggle="modal" data-target="#orderModal">
            Launch demo modal
        </button>
        <div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Автомобиль готов к заказу</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Вы добавили данный автомобиль себе в корзину, можете перейти в корзину для оформления заказа, либо продолжить просмотр.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Продолжить просмотр</button>
                        <a href="/cp"><button type="button" class="btn btn-primary">Перейти в корзину</button></a>
                    </div>
                </div>
            </div>
        </div>
    </#if>
    <div class="row">
        <div class="col-md-4 ">

                 <p ><h3>${order.getCarModel()}</h3>
                <p class="mt-5 text-secondary">Год выпуска: ${order.getYear()}</p>
                <p class="text-secondary">Объем: ${order.getCapacity()} л.</p>
                <p class="text-secondary">Расход: ${order.getConsumption()} л.</p>
            <h4> <p class="mt-5">Цена аренды в день:<span class="badge badge-danger">${order.getCost()} р.</span></p></h4>
            <#if order.isAvaliable()>
                <#if order.getUser()[0]?has_content>
                    <#if userHaveOrder>
                        <div class="alert alert-success" role="alert">
                            Данный автомобиль у вас в корзине!
                        </div>

                    <#else>
                        <form action="/order/${order.getId()}" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <h2><button class="btn btn-primary" >Добавить в корзину</button></h2>

                        </form>
                        <h2><button class="btn btn-primary" >Заказать в 1 клик</button></h2>

                    </#if>

                <#else>
                    <form action="/order/${order.getId()}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <h2><button class="btn btn-primary" >Добавить в корзину</button></h2>

                    </form>
                    <h2><button class="btn btn-primary" >Заказать в 1 клик</button></h2>
                </#if>


            </#if>

        </div>
        <div class="col-md-8 ml-5" style="max-width: 300px;">
            <img src="/img/${order.getPhotos()[0]}" alt="" style="width: 600px;" class="main_img" >

                    </div>
                </div>

        </div>


    </div>
    <div class="row  mt-5 mb-4">
        <div class="col-md-4"></div>
        <div class="col-md-8" id="description">
            <h3><label for="description">Описание автомобиля</label></h3>
           <p id="description" class="border ml-3 p-3"> ${order.getDescription()}</p>
        </div>

    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

<script src="/js/order_page.js" ></script>

</body>
</html>