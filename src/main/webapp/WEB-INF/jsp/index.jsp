<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<jsp:include page="fragments/headTag.jsp"/>
<body>
Place Manager <br>

<a href="/logout">Log out</a>
<h2>You are logged with username: ${username} and with roles: ${roles}</h2>
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
        </div>
    </div>

</div>


<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript" src="static/js/main.js" defer></script>
</body>
</html>