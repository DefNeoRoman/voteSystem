<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container">
    <h1>${users}</h1>
    <h1>${meals}</h1>
    <c:forEach items="${users}" var="user">
        <jsp:useBean id="user" scope="page" type="model.User"/>
        <tr>
            <td><c:out value="${user.name}"/></td>

        </tr>
    </c:forEach>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" scope="page" type="model.Meal"/>
        <tr>
            <td><c:out value="${meal.name}"/></td>

        </tr>
    </c:forEach>

</div>
<a href="home">home</a>
<a href="another">another</a>
</body>
</html>