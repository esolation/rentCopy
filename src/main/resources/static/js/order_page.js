$(document).ready(function() {

       $('.oneClickButton').click(function () {
              var today = new Date();
              var tomorrow = new Date();
              tomorrow.setDate(tomorrow.getDate()+1);
              $('#beginRent').val(today.toISOString().substr(0, 10));
              $('#endRent').val(tomorrow.toISOString().substr(0, 10));
       })


       $('#endRent').change(function () {

              var startDay = new Date($('#beginRent').val());
              var endDay = new Date($('#endRent').val());

              var millisBetween = startDay.getTime() - endDay.getTime();
              var days = millisBetween / (1000 * 3600 * 24);
              var result = Math.round(Math.abs(days));
              var discount = 0;
              if(result < 7 ){
                     discount = 0;
                     $('#totalCost').text(result * $('#carCost').text());
                     $('#discount').text(discount.toString());
              }
              else if(result <= 14){
                     discount = 2;
                     $('#totalCost').text((result * $('#carCost').text())*0.98);

                     $('#discount').text(discount.toString());
              }
              else if(result <= 21){
                     discount = 5;
                     $('#totalCost').text((result * $('#carCost').text())*0.95);

                     $('#discount').text(discount.toString());
              }
              else{
                     discount = 10;
                     $('#totalCost').text((result * $('#carCost').text())*0.9);

                     $('#discount').text(discount.toString());
              }

       })

})
