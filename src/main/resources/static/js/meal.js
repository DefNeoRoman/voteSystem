var datatableApi;
$(document).ready(function () {

    $("#selectMenuName")
        .change(function () {
            var str = "";
            str += $("#selectMenuName option:selected").text();
            $("#selectText").text(str);
            $("#menuId").val($("#selectMenuName").val());
        })
        .change();
    datatableApi = $('#mealDataTable').DataTable({

        //Какой-то из вышеперечисленных добавил и все заработало
        // со stackoverflow
        "ajax": {"url": "/admin/meals/getAll", "dataSrc": ""}, // или datasrc
        "processing": true,// или processing
        "serverSide": true,// или serverside
        "sAjaxDataProp": "data",// или sAjaxDataProp
        "columns": [
            {"data": "mealName"},
            {"data": "price"},
            {"data": "menuName"},
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
function renderEditBtn(data, type, row) {

    return "<a onclick=" + "updateRow(" + "\'" + row.mealId + "\'" + ",\'" + row.menuId + "\'" + ")" + ">" +
        "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></>";
}
function renderDeleteBtn(data, type, row) {
    return "<a onclick =" + "deleteRow(" + "\'" + row.mealId + "\'" + "," + "\'" + row.menuId + "\'" + ")" + " >" +
        "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";
}

function deleteRow(mealId, menuId) {

    $.ajax({
        url: '/admin/meals/delete/' + mealId + '/' + menuId,
        type: "DELETE",
        success: function () {
            location.reload();

        }
    });
}
function call(form) {
    var msg = $(form).serialize();
    console.log(msg);
    $.ajax({
        type: 'POST',
        url: '/admin/meals/update?' + msg,
        success: function (data) {

            datatableApi.clear().rows.add(data).draw();
        }
    });
    location.reload();
}
function updateRow(mealId, menuId) {

    var form = $('#detailsForm');
    var select = $('#selectMenuName');
    var html;
    var menuIndexes = [];
    var menuNames = [];
    $.get('/admin/meals/edit' + '/' + mealId + '/' + menuId, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name=" + key + "]").val(value);
            if (key === 'menuIds') {
                menuIndexes = value;
            }
            if (key === 'menuNames') {
                menuNames = value;
            }
            for (var i = 0; i < menuIndexes.length; i++) {
                html += '<option value="' + menuIndexes[i] + '">' + menuNames[i] + '</option>>';
            }
        });
        select.html(html);
        $("#editRow").modal();
    });
}
function add() {
    var form = $("#detailsForm");
    var select = $('#selectMenuName');
    var html;
    var menuIndexes = [];
    var menuNames = [];
    form.find(":input:not(.btn)").val("");
    $.get('/admin/meals/addMeal', function (data) {
        $.each(data, function (key, value) {
            form.find("input[name=" + key + "]").val(value);
            if (key === 'menuIds') {
                menuIndexes = value;
            }
            if (key === 'menuNames') {
                menuNames = value;
            }
            for (var i = 0; i < menuIndexes.length; i++) {
                html += '<option value="' + menuIndexes[i] + '">' + menuNames[i] + '</option>>';
            }
        });
        select.html(html);

    });
    $("#editRow").modal();
}

