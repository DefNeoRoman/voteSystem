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
            { "data": "menuName" },
            { "data": "cookName" },
            { "data": "placeName" },
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
    console.log(data);
    return "<a onclick="+"updateRow("+"\'"+row.menuId+"\'"+",\'"+row.placeId+"\'"+")"+">" +
        "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></>";
}
function renderDeleteBtn(data, type, row) {
    return "<a onclick ="+ "deleteRow("+"\'"+row.menuId+"\'"+","+"\'"+row.placeId+"\'"+")"+" >" +
        "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";
}

function deleteRow(menuId,placeId) {

    $.ajax({
        url: 'menus/delete/'+ menuId+'/'+placeId,
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
        url: 'menus/update?'+msg,
        success: function(data) {
            console.log(data);
            datatableApi.clear().rows.add(data).draw();
        }
    });
    location.reload();
}
function updateRow(menuId,placeId) {

    var form = $('#detailsForm');
    var select = $('#selectPlaceName');
    var html;
    var placeIndexes=[];
    var placeNames=[];
    $.get('menus/edit' +'/'+ menuId+'/'+placeId, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name=" + key + "]").val(value);
            if(key === 'placeIds'){
                placeIndexes = value;
            }
            if(key ==='placeNames'){
                placeNames = value;
            }
            for(var i=0; i< placeIndexes.length; i++){
                html+='<option value="'+placeIndexes[i]+'">'+placeNames[i]+'</option>>';
            }
        });
        select.html(html);
        $("#editRow").modal();
    });
}
function add() {
    var form = $("#detailsForm");
    var select = $('#selectPlaceName');
    var html;
    var placeIndexes=[];
    var placeNames=[];
    form.find(":input:not(.btn)").val("");
    $.get('menus/addMenu', function (data) {
        $.each(data, function (key, value) {
            form.find("input[name=" + key + "]").val(value);
            if(key === 'placeIds'){
                placeIndexes = value;
            }
            if(key ==='placeNames'){
                placeNames = value;
            }
            for(var i=0; i< placeIndexes.length; i++){
                html+='<option value="'+placeIndexes[i]+'">'+placeNames[i]+'</option>>';
            }
        });
        select.html(html);

    });
    $("#editRow").modal();
}

