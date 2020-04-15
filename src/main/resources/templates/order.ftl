<#import "main_template.ftl" as t>
<@t.header></@t.header>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-4 ">

                 <p ><h3>${order.getCarModel()}</h3>
                <p class="mt-5 text-secondary">Год выпуска: ${order.getYear()}</p>
                <p class="text-secondary">Объем: ${order.getCapacity()} л.</p>
                <p class="text-secondary">Расход: ${order.getConsumption()} л.</p>
            <h4> <p class="mt-5">Цена аренды в день:<span class="badge badge-danger">${order.getCost()} р.</span></p></h4>
            <form action="/order/${order.getId()}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <h2><button class="btn btn-primary" >Заказать</button></h2>
            </form>

        </div>
        <div class="col-md-8">
            <div > <img id="mainPhoto" class="mx-auto d-block main_photo"  src="/img/${order.getPhotos()[0]}" alt="" width="600" ></div>
                <div class="row">
                    <div class="col-md-8 mx-auto slide__thumbnails" >

                            <#list order.getPhotos() as photo>
                               <img  class="mx-auto mt-5 thumb_photo d-inline" src="/img/${photo}" height="100"  alt="">
                            </#list>

                    </div>
                </div>

        </div>


    </div>
    <div class="row  mt-5 mb-4">
        <div class="col-md-4"></div>
        <div class="col-md-8" id="description">
            <h3><label for="description">Описание автомобиля</label></h3>
           <p id="description" class="border"> ${order.getDescription()}</p>
        </div>

    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<script src="../static/js/order_page.js"></script>
</body>
</html>