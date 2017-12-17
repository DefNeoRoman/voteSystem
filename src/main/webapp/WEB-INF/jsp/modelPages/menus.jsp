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
    <table id="menuDataTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Name</th>
            <th>Who Prepared it?</th>
            <th>In Place</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>Name</th>
            <th>Who Prepared it?</th>
            <th>In Place</th>
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
                    <input type="hidden" id="menuId" name="menuId">
                    <input type="hidden" id="placeId" name="placeId">
                    <div class="form-group">
                        <label for="menuName" class="control-label col-xs-3">Menu Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="menuName" name="menuName"
                                   value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cookName" class="control-label col-xs-3">Who Prepared?</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="cookName" name="cookName" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cookName" class="control-label col-xs-3">In Place</label>

                        <div class="col-xs-9">
                            <div id="selectText">

                            </div>
                            <select name="" id="selectPlaceName">

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
<script type="text/javascript" src="../static/js/menu.js" defer></script>
</body>
</html>