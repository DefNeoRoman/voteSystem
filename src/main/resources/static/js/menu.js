function testEdit(uuid) {
var form = $("#editRow");

    $.get("menus/" + uuid, function (data) {
        console.log(data);
        document.getElementById('uuid').value = data.uuid;
        document.getElementById('description').value = data.name;
        document.getElementById('cName').value = data.cookName;

    });
    form.modal();
}