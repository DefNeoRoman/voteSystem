function call(form) {
    var msg   = $(form).serialize();
console.log(msg);
    $.ajax({
        type: 'POST',
        url: 'users/update?'+msg,
        success: function(data) {
           // console.log(data);
        }
    });

}