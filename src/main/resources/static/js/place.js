$(function(){
//написать функцию render для всех функционалов только что написанных
    $.getJSON("places", function(data) {
        console.log(data);
        render(data);
    });

});
function testFunction(d) {

        var $button = $(d);
        var oldValue = $(d).parent().find('.quantity').val();
        $button.parent().find('.incr-btn[data-action="decrease"]').removeClass('inactive');
        if ($button.data('action') == "increase") {
            var newVal = parseFloat(oldValue) + 1;
            console.log(newVal);
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
function deletePlace(uuid) {
    $.ajax({
        type: 'DELETE',
        url: 'places/?pUuid='+uuid,
        success: function(data) {

            render(data);
        }
    });

    location.reload();
}
function call(form) {
    var msg   = $(form).serialize();
    $.ajax({
        type: 'POST',
        url: 'places/update?'+msg,
        success: function(data) {

            render(data);
        }
    });
    location.reload();
}

function render(data){
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

        var placeUuid = value.uuid;

        html+=
            '<tr>'+ //tr - строка td - столбец

            '<td>'+'<input class="pName" id="pName" type="text" name="pName" form="place'+key+'" value="'+value.name+'"/>' + '<td>'+
            '<td>'+ //action="javascript:void(null); штука, чтобы форма не перезагружала страницу

            '<div class="count-input space-bottom">'+
            '<form method="POST" id="place'+key+'" class="postForm" action="javascript:void(null);" onsubmit="call(this)">'+
            '<input class="pUuid" id="pUuid" type="hidden" name="pUuid" value="'+value.uuid+'"/>'+
            '<a class="btn_minus" data-action="decrease" href="#" onclick="testFunction(this)">–</a>'+
            '<input class="quantity" id="pInput" type="text" name="quantity" value="'+value.votes+'"/>'+
            '<a class="incr-btn" data-action="increase" href="#" onclick="testFunction(this)">&plus;</a>' +
            '<input type="submit" value="save" >' +
            '</form>'+

            '</div>'+

            '</td>'+
            '<td class="tCol">'+
            '<a href="#" onclick="deletePlace(\''+placeUuid+'\')">'+
            '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>'+
            '</a>'+
            '</td>'+
            '</tr>';

    });

    html +='</tbody>'+
    '</table>'+  '<a class="btn btn-primary" onclick="addPlace()">'+
        '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>'+
        'add'+
        '</a>';
    $('#forPlaces').html(html);
}
function addPlace() {
    $("#editRow").modal();

}

