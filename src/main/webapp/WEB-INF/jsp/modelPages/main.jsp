<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en" xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="container">
    <div id="allPlaces">
        <div class="row">
            <div id="placeContainer" class="borderbottom">
                <div class="col-md-6">
                    <div class="col-md-5">

                    </div>
                </div>
                <div id="menuRow" class="h2">
                    <div id="mealRow" class="mealClass">

                    </div>
                </div>
                <c:if test="${!vote}">
                    <button class="btn btn-lg btn-primary vote" onclick="vote(this)">
                        vote
                    </button>
                </c:if>
            </div>
        </div>
    </div>

</div>
<div class="container">
    <c:if test="${vote}">
        <button class="btn btn-lg btn-primary cancel" onclick="cancel()">
            cancel
        </button>
    </c:if>
</div>
<input type="hidden" class="form-control" id="incredId" name="incredId" value="${wasIncredId}">
<jsp:include page="../fragments/footer.jsp"/>
<script type="text/javascript" src="static/js/main.js" defer></script>
</body>
</html>