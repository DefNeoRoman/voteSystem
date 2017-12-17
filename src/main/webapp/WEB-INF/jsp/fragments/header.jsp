<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    Place Manager <br>
    <%--сделать через sec-authorize--%>

    <a href="/main">Main Page</a>
    <a href="/admin/meals">Meals</a>
    <a href="/admin/menus">Menus</a>
    <a href="/admin/places">Places</a>
    <a href="/admin/users">Users</a>
    <a href="/admin/voteStory">Votes</a>
    <a href="/logout" class="btn btn-lg btn-primary">
        Log out
    </a>

    <hr>

</div>
