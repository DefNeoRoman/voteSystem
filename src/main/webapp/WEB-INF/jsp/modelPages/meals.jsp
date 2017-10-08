<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="model.Meal"/>
            <tr>

                <td><c:out value="${meal.name}"/></td>
                <td><c:out value="${meal.price}"/></td>
                <td><a href="meals/update?uuid=${meal.uuid}">редактировать</a></td>
                <td><a href="meals/delete?uuid=${meal.uuid}">удалить</a></td>
            </tr>
            <br>
        </c:forEach>
        <a class="btn btn-primary" onclick="add()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            add
        </a>
    </div>
    <div class="modal fade" id="editRow">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h2 class="modal-title" id="modalTitle"></h2>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="detailsForm" action="meals/create">
                        <input type="hidden" id="uuid" name="uuid">
                        <div class="form-group">
                            <label for="description" class="control-label col-xs-3">Название</label>

                            <div class="col-xs-9">
                                <input type="text" class="form-control" id="description" name="description"
                                       value="${meal.name}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="price" class="control-label col-xs-3">Цена</label>

                            <div class="col-xs-9">
                                <input type="number" class="form-control" id="price" name="price" value="${meal.price}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-offset-3 col-xs-9">
                                <input class="btn btn-primary" type="submit">
                                    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        </div>
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>

    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="/js/meals.js" defer></script>
</body>
</html>