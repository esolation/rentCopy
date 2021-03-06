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
            <#if order.isActive()>
                <#if order.getUser()?has_content>
                    <#if order.getUser().contains(user_id)>
                        <div class="alert alert-success" role="alert">
                            Данный автомобиль у вас в корзине!
                        </div>


                    </#if>

                <#else>
                    <form action="/order/${order.getId()}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <h2><button class="btn btn-primary" >Добавить в корзину</button></h2>
                    </form>
                </#if>


            </#if>

        </div>
        <div class="col-md-8 ml-5" style="max-width: 300px;">
            <img src="/img/${order.getPhotos()[0]}" alt="" style="width: 600px;" class="main_img" >
                    <div class="row">

                        <#list order.getPhotos() as photo>

                          <div id="off_img" class="col-md-4 d-block"><img class="mt-3 ml-1 w-100" src="/img/${photo}" alt=""></div>
                        </#list>

                    </div>
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

<script src="/js/order_page.js" ></script>

</body>
</html>