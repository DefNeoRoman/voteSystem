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