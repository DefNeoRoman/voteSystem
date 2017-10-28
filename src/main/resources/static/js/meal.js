var datatableApi
$(document).ready(function() {

    datatableApi = $('#mealDataTable').DataTable( {
        //Какой-то из вышеперечисленных добавил и все заработало
        // со stackoverflow
        "ajax":{"url":"meals","dataSrc":""}, // или datasrc
        "processing": true,// или processing
        "serverSide": true,// или serverside
        "sAjaxDataProp": "data",// или sAjaxDataProp
        "columns": [
            { "data": "name" },
            { "data": "price" },
            { "data": "menus.name" },

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

    return "<a >" +
        "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></a>";

}

function renderDeleteBtn(data, type, row) {

    return "<a>" +
        "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";

}
function add() {
    $("#editRow").modal();
}
function deleteEntity (uuid) {

    $.get( "meals/delete/"+uuid);
    location.reload();
}
function edit(name,price,uuid) {
    $("#editRow").modal();
     document.getElementById('uuid').value = uuid;
     document.getElementById('description').value = name;
     document.getElementById('price').value = price;
}