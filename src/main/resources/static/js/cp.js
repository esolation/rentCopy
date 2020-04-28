$(function () {




    $("#cost").change(function () {
        var factor = $("#cost option:selected").text();
        var str = $("#carCost").text().replace(/\s/g, '');
        var finalValue = str*factor;
        $("#finalCostText").text(finalValue);
        $("#finalCost").attr("value", finalValue )


    });





})