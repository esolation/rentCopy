<#import "main_template.ftl" as t>
<@t.header>
</@t.header>
<div class="container">
<div class="card" style="width: 18rem;">
    <ul class="list-group list-group-flush">
         <li class="list-group-item">Имя пользователя: <strong>${user.getUsername()}</strong></li>
        <li class="list-group-item">Email: <strong>${user.getEmail()}</strong></li>
       <li class="list-group-item"> Номер пасспорта: <strong>${user.getPassportNumb()}</strong></li>
    </ul>
</div>
</div>
</body>
</html>