var datatableApi;
$(document).ready(function() {

    datatableApi = $('#placeDataTable').DataTable( {

        //Какой-то из вышеперечисленных добавил и все заработало
        // со stackoverflow
        "ajax":{"url":"places","dataSrc":""}, // или datasrc
        "processing": true,// или processing
        "serverSide": true,// или serverside
        "sAjaxDataProp": "data",// или sAjaxDataProp
        "columns": [
            { "data": "name" },
            { "data": "vote" },
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ]
    } );
});
function renderEditBtn(data, type, row) {

    return "<a onclick="+"updateRow("+"\'"+row.id+"\')"+">" +
        "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></>";
}
function renderDeleteBtn(data, type, row) {
    return "<a onclick ="+ "deleteRow("+"\'"+row.id+"\'"+")"+" >" +
        "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";
}

function deleteRow(placeId) {

    $.ajax({
        url: 'places/delete'+'/'+placeId,
        type: "DELETE",
        success: function () {
            location.reload();

        }
    });
}
function call(form) {
    var msg   = $(form).serialize();

    $.ajax({
        type: 'POST',
        url: 'places/update?'+msg,
        success: function(data) {
          datatableApi.clear().rows.add(data).draw();
        }
    });
    location.reload();
}
function updateRow(placeId) {
    console.log("hello");
    var form = $('#detailsForm');

    $.get('places/edit' +'/'+placeId, function (data) {
        console.log(data);
        $.each(data, function (key, value) {
            form.find("input[name=" + key + "]").val(value);

        });
    });
    $("#editRow").modal();
}
function add() {
    var form = $("#detailsForm");
     form.find(":input:not(.btn)").val("");
    $("#editRow").modal();
}

