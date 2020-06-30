<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
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
    <#if message??>
        <div class="d-flex justify-content-center mt-3">
            <div class="alert alert-danger" role="alert">
                ${message}
            </div>
        </div>
    </#if>
    <#if passCheckError??>
        <div class="d-flex justify-content-center mt-3">
            <div class="alert alert-danger" role="alert">
                ${passCheckError}
            </div>
        </div>
    </#if>
    <div class="d-flex justify-content-center mt-3">
        <div class="card">
            <div class="card-header">
                <h3 style="color:black;">Регистрация</h3>

            </div>
            <div class="card-body">

                <form action="/registration" method="post">
                    <label for="username"><h5>Имя пользователя</h5></label>
                    <div class="input-group form-group">

                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input value="<#if user?has_content>${user.getUsername()}</#if>" type="text" id="username" class="form-control ${(RequestParameters.usernameError??)?string('is-invalid','')}" placeholder="Логин" name="username">
                        <#if RequestParameters.usernameError??>
                        <div class="invalid-feedback">
                            ${RequestParameters.usernameError}
                        </div>
                        </#if>
                    </div>
                    <label for="password"><h5>Придумайте пароль</h5></label>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input value="<#if user?has_content>${user.getPassword()}</#if>" id="password" type="password" name="password" class="form-control ${(RequestParameters.passwordError??)?string('is-invalid','')}" placeholder="Пароль">
                        <#if RequestParameters.passwordError??>
                            <div class="invalid-feedback">
                                ${RequestParameters.passwordError}
                            </div>
                        </#if>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </div>
                    <label for="email"><h5>Почта</h5></label>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-at"></i></span>
                        </div>
                        <input value="<#if user?has_content>${user.getEmail()}</#if>" id="email" type="email" class="form-control ${(RequestParameters.emailError??)?string('is-invalid','')}" placeholder="Email" name="email">
                        <#if RequestParameters.emailError??>
                            <div class="invalid-feedback">
                                ${RequestParameters.emailError}
                            </div>
                        </#if>
                    </div>
                    <label for="passport"><h5>Серия и номер пасспорта</h5></label>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-passport"></i></span>
                        </div>
                        <input value="<#if user?has_content>${user.getPassportNumb()}</#if>" id="password" type="text" class="form-control ${(RequestParameters.passportNumbError??)?string('is-invalid','')}" placeholder="КН 1111111" name="passportNumb">
                        <#if RequestParameters.passportNumbError??>
                            <div class="invalid-feedback">
                                ${RequestParameters.passportNumbError}
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