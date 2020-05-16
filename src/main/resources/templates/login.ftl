<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
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
    <#if RequestParameters.reg??>
        <div class="d-flex justify-content-center mt-5">
            <div class="alert alert-success" role="alert">
                Регистрация прошла успешно. Войдите в систему используя свой логин и пароль.
            </div>
        </div>
        <#elseif RequestParameters.error??>
            <div class="d-flex justify-content-center mt-5">
                <div class="alert alert-danger" role="alert">
                    Введен неверный логин или пароль. Повторите попытку.
                </div>
            </div>

    </#if>


    <div class="d-flex justify-content-center mt-5">
        <div class="card">
            <div class="card-header">
                <h3 style="color:black;">Вход</h3>
                <div class="d-flex justify-content-end social_icon">

                    <span><i class="fab fa-google-plus-square"></i></span>

                </div>
            </div>
            <div class="card-body">
                <form action="/login" method="post">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="Логин" name="username">

                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" name="password" class="form-control" placeholder="Пароль">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </div>

                    <div class="form-group">
                        <input type="submit" value="Войти" class="btn float-right login_btn">
                    </div>
                </form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    <a href="/registration">Регистрация</a>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>