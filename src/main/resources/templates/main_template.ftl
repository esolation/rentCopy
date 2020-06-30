<#macro header >
    <!doctype html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Аренда авто</title>
    </head>
    <body>


        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="/hello">
                <img src="/img/arenda-avto-bez-zaloga.png" alt="" style="width: 100px;">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/hello">Главная<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <#if Session["SPRING_SECURITY_CONTEXT"]??><a class="nav-link" href="/history">История заказов</a>
                    </li>

                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Выйти</button></#if>
                        </form>
                    </li>
                </ul>
                <#if Session["SPRING_SECURITY_CONTEXT"]??>
                <#if isAdmin??>
                    <#if isAdmin == true>
                        <a href="/admin/active" class="btn btn-primary mr-3">Админ панель
                            <#if notification??>
                            <#if notification != 0>
                                <span class="badge badge-danger"> ${notification}</span>
                            </#if></#if>
                        </a>
                        <a href="/cp" class="btn btn-success">Корзина <i class="fas fa-cart-arrow-down"></i></a>
                    <#else>
                        <a href="/order/myOrders" class="btn btn-info mr-2">Мои заказы <i class="fas fa-car"></i></a>
                        <a href="/cp" class="btn btn-danger">Корзина <i class="fas fa-cart-arrow-down"></i></a>

                    </#if>
                </#if>
                    <#else >
                        <a href="/login" class="btn btn-primary mr-3">Войти</a>
                </#if>

            </div>
        </nav>


</#macro>