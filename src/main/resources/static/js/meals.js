function add() {
    $("#editRow").modal();
}
function edit(name,price) {
    $("#editRow").modal();
    document.getElementById('description').value = name;

    document.getElementById('price').value = price;

}