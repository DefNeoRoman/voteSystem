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

            html+='<tr>';
            html+='<td>'+value.name+'</td>';
            html+='<td>'+value.votes+'</td>';
            html+='</tr>';
        });

        html +='</tbody>';
        html += '</table>';
        $('#forPlaces').html(html);
    });

});

