var datatableApi;
$(document).ready(function () {
    $.get('/admin/users/getAll', function (data) {
        console.log(data);

    });
    datatableApi = $('#userDataTable').DataTable({
        //Какой-то из вышеперечисленных добавил и все заработало
        // со stackoverflow
        "ajax": {"url": "users/getAll", "dataSrc": ""}, // или datasrc
        "processing": true,// или processing
        "serverSide": true,// или serverside
        "sAjaxDataProp": "data",// или sAjaxDataProp
        "columns": [
            {"data": "username"},
            {"data": "email"},
            {
                "data": "registerDate",

            },
            {"data": "authorities"},
            {"data": "password"},
            {"data": "enabled"},
            {"data": "vote"},
            {
                "data": "canVote"

            },
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
    });

});
function updateRow(id) {
    var form = $('#detailsForm');
    $.get('users' + '/' + id, function (data) {
        console.log(data);
        $.each(data, function (key, value) {
            form.find("input[name=" + key + "]").val(value);
        });
        $("#editRow").modal();
    });
}

function deleteRow(id) {

    $.ajax({
        url: 'users?id=' + id,
        type: "DELETE",
        success: function () {
            location.reload();
            console.log("hello");
        }
    });
}
function call(form) {
    var msg = $(form).serialize();

    $.ajax({
        type: 'POST',
        url: 'users/update?' + msg,
        success: function (data) {
            console.log(data);
            datatableApi.clear().rows.add(data).draw();
        }
    });
    location.reload();
}
function renderEditBtn(data, type, row) {

    return "<a onclick=" + "updateRow(" + "\'" + row.id + "\')" + ">" +
        "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></a>";

}

function renderDeleteBtn(data, type, row) {

    return "<a onclick =" + "deleteRow(" + "\'" + row.id + "\')" + ">" +
        "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";

}
function enable(checkbox) {
    var enabled = checkbox.is(":checked");
    console.log(enabled);

    if (enabled === false) {

        $(checkbox).removeProp("checked");
    }
    console.log($(checkbox).val());
}
function add() {
    var form = $("#detailsForm");
    form.find(":input:not(.btn)").val("");
    $("#editRow").modal();
}