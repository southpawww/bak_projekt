

$(function() {

    /* Ajax navigation */
    $('ul.ulli li.ulli a').click(function(e) {
        e.preventDefault();
        $('.box').load($(this).attr('href')+' .box');
    });

    /* Toggle category item - use .on('click') and delegate event */
    $('#category-wrapper').on('click', '.toggle-item', function(e) {
        e.preventDefault();
        $(this).parent().next('.category-item-content').toggle();
    });

});
