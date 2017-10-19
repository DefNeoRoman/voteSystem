$(function(){

    $.getJSON("places", function(data) {
        console.log(data);
        var html = '';
        html += '<table>';
            html += '<thead>';
                html+= '<tr>';
                    html+='<th>Name</th>';
                    html+='<th>Votes</th>';
                html+= '</tr>';
        html += '</thead>';
        html += '<tbody>';


        $.each(data, function(key, value){
            console.log(value.uuid);
            html+='<tr>'+ //tr - строка

            '<td>'+value.name + '<td>'+ // td - столбец
            '<td>'+ //action="javascript:void(null); штука, чтобы форма не перезагружала страницу
                '<form method="POST" class="postForm" action="javascript:void(null);" onsubmit="call(this)">'+
                '<div class="count-input space-bottom">'+
                '<input class="pUuid" id="pUuid" type="hidden" name="pUuid" value="'+value.uuid+'"/>'+
                    '<a class="incr-btn" data-action="decrease" href="#" onclick="testFunction(this)">–</a>'+
                        '<input class="quantity" id="pInput" type="text" name="quantity" value="'+value.votes+'"/>'+
                    '<a class="incr-btn" data-action="increase" href="#" onclick="testFunction(this)">&plus;</a>' +
                '<input type="submit" value="save" >'+

                '</div>'+
                '</form>'+
            '</td>';

            html+='</tr>';
        });

        html +='</tbody>';
        html += '</table>';
        $('#forPlaces').html(html);
    });

});
function testFunction(d) {
        var msg   = $(d).parent().parent().find('.postForm').serialize();
        console.log(d);
        console.log(msg);
        var $button = $(d);
        var oldValue = $(d).parent().find('.quantity').val();
        $button.parent().find('.incr-btn[data-action="decrease"]').removeClass('inactive');
        if ($button.data('action') == "increase") {
            var newVal = parseFloat(oldValue) + 1;

        } else {
            // Don't allow decrementing below 1
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
                $button.addClass('inactive');
            }
        }
        $button.parent().find('.quantity').val(newVal);



}
function call(form) {
    var msg   = $(form).serialize();

    //
    $.ajax({
        url: 'places/update?'+msg,
        success: function(data) {
           console.log("hello")
        }
    });
}
