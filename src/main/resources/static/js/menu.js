function testEdit() {
    var form = $("#editRow");
   
    form.modal();
    var formData = JSON.stringify($("#menuForm").serializeArray());
    // If you have a single JSON string representing an array of objects:
    // Yes it is

    var jsons = JSON.parse(formData);
    document.getElementById('editUuid').value = jsons[0].value;
    document.getElementById('description').value = jsons[1].value;
    document.getElementById('cName').value = jsons[2].value;


}