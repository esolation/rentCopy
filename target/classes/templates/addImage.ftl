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
<div class="container">
    <div class="row">
        <div class="col-lg-12">

<form action="/addImage" enctype="multipart/form-data" method="post">
    <div class="form-group">
    <label for="carModel">Название автомобиля</label>
    <input type="text" class="form-control" id="carModel" name="carModel" placeholder="Лада Седан">
    </div>
    <div class="form-group">
        <input type="text" name="year" placeholder="Год производства">
        <input type="text" name="capacity" placeholder="Объем">
        <input type="text" name="consumption" placeholder="Расход топлива">
    </div>
    <div class="form-group">
        <label for="fullDescription">Полное описание автомобиля</label>
        <textarea class="form-control" name="description" id="fullDescription"  rows="5"></textarea>
    </div>
    <div class="form-group">
        <label for="cost">Цена аренды</label>
        <input type="text" name="cost" id="cost" placeholder="00.0">
    </div>
    <div id="copyFile">
    <div class="form-group">
                <label for="fileName">Выберите файл</label>
                <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
    </div>

    </div>
    <div id="pasteFile">

    </div>
    <button id="addPhoto" type="button" class="btn btn-primary mb-2">Добавить еще фото</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" class="btn btn-success mb-2">Отправить</button>
</form>

        </div>
    </div>
</div>


<#--<form action="/addImage" enctype="multipart/form-data" method="post">-->
<#--    <input type="file" name="file">-->
<#--    <input type="file" name="file">-->
<#--    <input type="text" name="carModel">-->
<#--    <input type="text" name="description">-->
<#--    <input type="text" name="coast">-->
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--    <input type="submit" value="Отправить">-->
<#--</form>-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="../static/js/additional_page.js"></script>
</body>
</html>