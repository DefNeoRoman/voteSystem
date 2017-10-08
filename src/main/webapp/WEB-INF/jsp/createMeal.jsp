<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">

</head>
<body>
<div class="container">
   Название и цена для еды
    кнопка add meal
    <jsp:useBean id="meal" scope="request" type="model.Meal"/>
    <form action="/createMeal" method="post">
        <h2>Название</h2>
        <input type="text" value="${meal.name}" size=40 name="description">
        <h2>Цена</h2>
        <input type="number" value="${meal.price}" name="price">
        <button type="submit">save</button>
    </form>
    <a href="/">back</a>
</div>
<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
</body>
</html>