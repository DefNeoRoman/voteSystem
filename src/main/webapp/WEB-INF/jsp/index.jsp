<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en" xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="fragments/headTag.jsp"/>
<body>

<div class="container">
    <sec:authorize access="hasRole('ADMIN')">
        <a href="/main" class="btn btn-lg btn-primary">Admin`s console</a>
    </sec:authorize>
    <div class="col-md-4">
        <h1>Place Manager</h1>
        <h1>Current time</h1>
        <div id="timedisplay"></div>
    </div>

    <div class="col-md-4"></div>
    <div class="col-md-4">
        <br>
        <br>
        <a href="/logout" class="btn btn-lg btn-primary">
            Log out
        </a>
    </div>

</div>
<br>
<br>
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
            </div>
            <c:if test="${!vote}">
                <button class="btn btn-lg btn-primary vote" onclick="vote(this)">
                    vote
                </button>
            </c:if>

        </div>
    </div>

</div>
<div class="container">
    <c:if test="${vote}">
        <button class="btn btn-lg btn-primary cancel" onclick="cancel()">
            cancel
        </button>
    </c:if>
    <c:if test="${!canVote}">
        <h2> user can't change his mind</h2>
    </c:if>
</div>

<input type="hidden" class="form-control" id="incredId" name="incredId" value="${wasIncredId}">
<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript" src="static/js/main.js" defer></script>
</body>
</html>