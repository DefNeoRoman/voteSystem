<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en" xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="container">
   <h1>VoteStoryPanel</h1>
    <div class="pageContainer">
        <div class="voteStory">
            <span class="userName"></span>
            <span class="placeName"></span>
            <span class="voteDate"></span>
        </div>
    </div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
<script type="text/javascript" src="../static/js/votestory.js" defer></script>
</body>
</html>