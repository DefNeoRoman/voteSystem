var datatableApi;
$(document).ready(function() {

     datatableApi = $('#userDataTable').DataTable( {
        //Какой-то из вышеперечисленных добавил и все заработало
        // со stackoverflow
        "ajax":{"url":"users","dataSrc":""}, // или datasrc
        "processing": true,// или processing
        "serverSide": true,// или serverside
        "sAjaxDataProp": "data",// или sAjaxDataProp
        "columns": [
            { "data": "name" },
            { "data": "email" },
            { "data": "registerDate" },
            { "data": "enabled" },
            { "data": "vote" },
            { "data": "canVote" },
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

} );
function updateRow(uuid) {
    var form = $('#detailsForm');
    $.get('users' +'/'+ uuid, function (data) {
        console.log(data);
        $.each(data, function (key, value) {
            form.find("input[name=u" + key + "]").val(value);
        });
        $("#editRow").modal();
    });
}

function deleteRow(uuid) {
    console.log(uuid);
    $.ajax({
        url: 'users?userUuid='+ uuid,
        type: "DELETE",
        success: function () {
            location.reload();
           console.log("hello");
        }
    });
}
function call(form) {
    var msg   = $(form).serialize();
    console.log(msg);
    $.ajax({
        type: 'POST',
        url: 'users/update?'+msg,
        success: function(data) {
            console.log(data);
            datatableApi.clear().rows.add(data).draw();
        }
    });
    location.reload();
}
function renderEditBtn(data, type, row) {

        return "<a onclick="+"updateRow("+"\'"+row.uuid+"\')"+">" +
            "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></a>";

}

function renderDeleteBtn(data, type, row) {

        return "<a onclick ="+ "deleteRow("+"\'"+row.uuid+"\')"+">" +
            "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";

}
function enable(checkbox){
    var enabled = checkbox.is(":checked");
    console.log(enabled);

    if(enabled === false){
        console.log("hello");
        $(checkbox).removeProp("checked");
    }
    console.log($(checkbox).val());
 }
function add() {
   var form = $("#detailsForm");
    form.find(":input").val("");
    $("#editRow").modal();
}