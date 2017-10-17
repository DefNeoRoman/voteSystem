$(function(){

    $.getJSON("places", function(data) {
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

            html+='<tr>'+ //tr - строка

            '<td>'+value.name + '<td>'+ // td - столбец
            '<td>'+
                '<div class="count-input space-bottom">'+
                    '<a class="incr-btn" data-action="decrease" href="#" onclick="testFunction()">–</a>'+
                        '<input class="quantity" type="text" name="quantity" value="'+value.votes+'"/>'+
                    '<a class="incr-btn" data-action="increase" href="#">&plus;</a>'+
                '</div>'+

            '</td>';

            html+='</tr>';
        });

        html +='</tbody>';
        html += '</table>';
        $('#forPlaces').html(html);
    });

});
function testFunction() {

    //Переделать надо
    $(".incr-btn").on("click", function (e) {
        var $button = $(this);
        var oldValue = $button.parent().find('.quantity').val();
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
        e.preventDefault();
    });

}

