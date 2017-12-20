function call(form) {
    var msg   = $(form).serialize();
console.log(msg);
    $.ajax({
        type: 'POST',
        url: 'admin/users/registration?'+msg,
        success: function(data) {
           console.log(data);
        }
    });

}