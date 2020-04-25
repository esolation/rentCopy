$(function () {

$("#if_damaged").change(function () {

    var select = $("option:selected").val();
    if(select === "Повреждена"){
        $(".after").append(" <div class=\"form-group\" id='message'> \n" +
            "    <label for=\"textArea\">Описание проблемы</label>\n" +
            "    <textarea name='message' class=\"form-control\" id=\"textArea\" placeholder='Пожалуйста введите краткое описание проблемы' rows=\"3\"></textarea>\n" +
            "  </div>" +
            "<div class='form-group' id='money'>" +
            "<label for='moneyInput'>Цена ремонта</label>"+
            " <div class=\"input-group\">\n" +
            "  <div class=\"input-group-prepend\">\n" +
            "    <span class=\"input-group-text\">Р</span>\n" +
            "  </div>\n" +
            "  <input name='money' type=\"text\" class=\"form-control\" id='moneyInput' aria-label=\"Amount (to the nearest dollar)\">\n" +
            "</div>"+
        "</div>");
    }
    else
        {
            $("#money").remove();
            $("#message").remove();

        }

})
})