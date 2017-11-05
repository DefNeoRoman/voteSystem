//https://stackoverflow.com/questions/43671166/how-to-remove-undefined-on-object-keys-for-foreach
var htmlString      = '';
var place = '';
var menu = '';
var meal = '';
var allPlaces       = $('#allPlaces');

var row        = $(".row");



var mealRow         = $("#mealRow");

var placeContainer  = $("#placeContainer");


$(document).ready(function() {

    $.get('/main/getData', function (data) {
        console.log(data);
        var menuArray = [];

        $.each(data, function (key, value) {
            place = key;
            menuArray = value;
            var MenuTO;

            for(var i = 0; i < menuArray.length; i++){
              var menuRow = $("#menuRow").empty();
              MenuTO = menuArray[i];
              console.log(MenuTO);
              menuRow.append(MenuTO.menuName);
              htmlString += menuRow.prop('outerHTML');

            }

        });

        allPlaces.html(htmlString);
    });

});
