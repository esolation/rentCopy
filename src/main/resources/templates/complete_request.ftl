<#import "main_template.ftl" as t>
<@t.header></@t.header>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form method="post">
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Состояние</label>
                    <select class="form-control" id="if_damaged">
                        <option selected>Без повреждений</option>
                        <option>Повреждена</option>
                    </select>
                </div>

                    <div class="after"></div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-success mt-5">Завершить</button>



            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="../../static/js/complete_request.js" type="text/javascript"></script>
</body>
</html>