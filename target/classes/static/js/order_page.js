$(document).ready(function(){
    $('.slide__thumbnails .thumb_photo').click(function(){

    //     var imgThumb = $(this).attr('src');
    //     var oldImg = $('.full_img');
    //     var imgFull = $('<img class="mx-auto d-block main_photo" width="600" src="' + imgThumb +' ">');
    //     imgFull.hide();
    //     $('.main_photo').prepend(imgFull);
    //     imgFull.show(1);
    //     oldImg.hide(1,function(){
    //         $(this).remove();
    //     });
    // });
        $('a.switchPhoto').magnificPopup();
})});
// $('thumb:first').click();