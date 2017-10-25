<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>name</th>
            <th>meal_id</th>
            <th>menu_id</th>
            <th>id</th>
        </tr>
        </thead>
        <c:forEach items="${menumeals}" var="menumeal">
            <jsp:useBean id="menumeal" scope="page" type="model.MenuMeal"/>

            <tr>

                <td><c:out value="${menumeal.name}"/></td>
                <td><c:out value="${menumeal.mealId}"/></td>
                <td><c:out value="${menumeal.menuId}"/></td>
                <td><c:out value="${menumeal.id}"/></td>
                <td>
                    <button type="button" class="btn btn-default" onclick="edit('${menumeal.name}')">

                        Edit
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="deleteEntity('${menumeal.id}')">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </button>
                </td>
            </tr>
            <br>
        </c:forEach>
    </table>


    <a class="btn btn-primary" onclick="add()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        add communication
    </a>
    menu meal jsp
</div>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>