var htmlString = '';
var place = '';
var menu = '';
var allPlaces = $('#allPlaces');
var row = $(".row");
var mealRow = $("#mealRow");
var placeContainer = $("#placeContainer");
var menuRow = $("#menuRow");
var colMd6 = $(".col-md-6");
var colMd5 = $(".col-md-5");
var voteButton = $(".vote");

$(document).ready(function () {
    $.get('/main/getData', function (data) {
        var menuArray = [];
        var mealArray = [];
        $.each(data, function (key, value) {
            placeContainer.empty();
            row.empty();
            colMd6.empty();
            placeContainer.append("<div class=\"col-md-6\"><p>" + key + "</p></div>");
            menuArray = value;
            voteButton.attr('id', menuArray[0].placeId);
            var MenuTO;
            for (var i = 0; i < menuArray.length; i++) {
                menuRow.empty();
                MenuTO = menuArray[i];
                menuRow.append("<div class=\"col-md-6\">" + MenuTO.menuName + "</div>");
                mealArray = MenuTO.mealTOS;

                colMd5.empty();
                for (var j = 0; j < mealArray.length; j++) {
                    mealRow.empty();
                    mealRow.append(mealArray[j].mealName);
                    colMd5.append(mealRow.prop("outerHTML"));
                }
                menuRow.append(colMd5.prop("outerHTML"));
                colMd6.append(menuRow.prop("outerHTML") + "<br><hr>");
            }
            placeContainer.append(colMd6);
            placeContainer.append(voteButton);
            row.append(placeContainer.prop("outerHTML") + "<br><hr>");
            htmlString += row.prop("outerHTML");
        });
        allPlaces.html(htmlString);
    });
});
function vote(button) {
    var id = $(button).attr('id');
    $.ajax({
        type: 'POST',
        url: 'main/incVote?id='+ id,
        success: function (data) {

        }
    });
     location.reload();
}
function cancel() {
   var id = $("#incredId").val();
      $.ajax({
            type: 'POST',
            url: 'main/decVote?id='+id,
            success: function (data) {
            }
        });
         location.reload();
}
function getDate()
{
    var date = new Date();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    if(seconds < 10)
    {
        seconds = '0' + seconds;
    }
    document.getElementById('timedisplay').innerHTML = hours + ':' + minutes + ':' + seconds;
}
setInterval(getDate, 0);

function changeVoteTime(form){
    var msg = $(form).serialize();
    console.log(msg);
     $.ajax({
                type: 'POST',
                url: 'main/changeVoteTime?'+msg,
                success: function (data) {
                }
            });
             location.reload();
}