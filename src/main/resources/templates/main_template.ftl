<#macro header >
    <!doctype html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Document</title>
    </head>
    <body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Аренда автомобилей</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/hello">Главная<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">История заказов</a>
            </li>

            <li class="nav-item">
                <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Выйти</button>
                </form>
            </li>
        </ul>
        <#if isAdmin??>
            <a href="/cp" class="btn btn-success">Добавить автобмобиль</a>
        </#if>
        <a href="/cp" class="btn btn-primary">Личный кабинет</a>
    </div>
</nav>
</#macro>