<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en" xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="container">
    <a class="btn btn-primary" onclick="add()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true">Add</span>

    </a>
    <table id="mealDataTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>In Menu</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>In Menu</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </tfoot>
    </table>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm" method="post" action="javascript:void(null);"
                      onsubmit="call(this)">
                    <input type="hidden" id="mealId" name="mealId">
                    <input type="hidden" id="menuId" name="menuId">
                    <div class="form-group">
                        <label for="mealName" class="control-label col-xs-3">Meal Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="mealName" name="mealName"
                                   value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="control-label col-xs-3">Meal Price</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="price" name="price" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="control-label col-xs-3">In Menu</label>

                        <div class="col-xs-9">
                            <div id="selectText">

                            </div>
                            <select name="" id="selectMenuName">

                            </select>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <input class="btn btn-primary" type="submit" value="save">
                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../fragments/footer.jsp"/>
<script type="text/javascript" src="../static/js/meal.js" defer></script>
</body>
</html>