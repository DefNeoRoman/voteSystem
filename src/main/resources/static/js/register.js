function call(form) {
    var msg   = $(form).serialize();
    $.ajax({
        type: 'POST',
        url: 'admin/users/registerUser?'+msg,
        success: function(data) {
            $("#editRow").modal("hide");
        }
    });
location.reload();
}
function add() {
    var form = $("#detailsForm");
    form.find(":input:not(.btn)").val("");
    $("#editRow").modal();
}