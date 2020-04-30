<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
<div class="container">
    <h2>Регистрация</h2>

    <form class="form-horizontal" action="registration" method="post">
        <div class="form-group">
            <label class="control-label col-xs-3 ${(userNameError??)?string('is-invalid','')}" for="login">Логин:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="login" name="username" placeholder="Логин">
                <#if userNameError??>
                <div class="invalid-feedback">
                    ${userNameError}
                </div>
                </#if>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="password">Пароль:</label>
            <div class="col-xs-9">
                <input type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid','')}" id="password" placeholder="Введите пароль">
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="email">Email:</label>
            <div class="col-xs-9">
                <input type="email" name="email" class="form-control ${(emailError??)?string('is-invalid','')}" id="email" placeholder="Email">
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
        </div>





        <div class="form-group">
            <label class="control-label col-xs-3" for="postalAddress">Номер пасспорта:</label>
            <div class="col-xs-9">
                <input  class="form-control ${(passportNumb??)?string('is-invalid','')}" id="postalAddress" placeholder="КН 1111111">
                <#if passportNumber??>
                    <div class="invalid-feedback">
                        ${passportNumber}
                    </div>
                </#if>
            </div>
        </div>


        <input type="hidden" name="${_csrf}" value="${_csrf.token}">
        <input type="submit" class="btn btn-success" value="Зарегистрироваться">
    </form>
</div>
</body>
</html>