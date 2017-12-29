var htmlString = '';
var container = $('.pageContainer')
$(document).ready(function () {
var voteStory = $('.voteStory');
var userName  = $('.userName');
var placeName = $('.placeName');
var voteDate  = $('.voteDate');
    $.get('voteStory/getData', function (data) {
         $.each(data, function (key, value) {
                    voteStory.empty();
                    userName.empty();
                    placeName.empty();
                    voteDate.empty();
                    userName.append("User "+value.userName + " ");
                    placeName.append("voted for "+value.placeName);
                    voteDate.append(" in " + value.date);
                    voteStory.append(userName);
                    voteStory.append(placeName);
                    voteStory.append(voteDate);
                 htmlString += voteStory.prop("outerHTML");

    });
     container.html(htmlString);
});
});