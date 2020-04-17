$(document).ready(function() {
        $('.off_img').click(function () {

            // var img = $(".off_img").attr('src');
            console.log($('#off_img').attr('src'));
            $('.main_img').attr('src',img);
        })
})
