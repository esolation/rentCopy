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
    <div class="d-flex justify-content-center h-100 ">
        <div class="card">
            <div class="card-header">
                <h3 style="color:black;">Регистрация</h3>

            </div>
            <div class="card-body">
                <#if message??>
                    ${message}
                </#if>
                <form action="/registration" method="post">
                    <label for="username"><h5>Имя пользователя</h5></label>
                    <div class="input-group form-group">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" id="username" class="form-control ${(usernameError??)?string('is-invalid','')}" placeholder="Логин" name="username">
                        <#if usernameError??>
                        <div class="invalid-feedback">
                            ${usernameError}
                        </div>
                        </#if>
                    </div>
                    <label for="password"><h5>Придумайте пароль</h5></label>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input id="password" type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid','')}" placeholder="Пароль">
                        <#if passwordError??>
                            <div class="invalid-feedback">
                                ${passwordError}
                            </div>
                        </#if>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </div>
                    <label for="email"><h5>Почта</h5></label>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-at"></i></span>
                        </div>
                        <input id="email" type="email" class="form-control ${(emailError??)?string('is-invalid','')}" placeholder="Email" name="email">
                        <#if emailError??>
                            <div class="invalid-feedback">
                                ${emailError}
                            </div>
                        </#if>
                    </div>
                    <label for="passport"><h5>Серия и номер пасспорта</h5></label>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-passport"></i></span>
                        </div>
                        <input id="password" type="text" class="form-control ${(passportNumbError??)?string('is-invalid','')}" placeholder="КН 1111111" name="passportNumb">
                        <#if passportNumbError??>
                            <div class="invalid-feedback">
                                ${passportNumbError}
                            </div>
                        </#if>
                    </div>

                    <div class="form-group">
                        <input type="submit" value="Регистрация" class="btn float-right login_btn">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>