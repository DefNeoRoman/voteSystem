function call(form) {
    var msg   = $(form).serialize();
console.log(msg);
    $.ajax({
        type: 'POST',
        url: 'users/registration',
        success: function(data) {
            console.log(data);

        }
    });

}