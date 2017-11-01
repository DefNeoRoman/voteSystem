<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="container">
    <a class="btn btn-primary" onclick="add()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true">Add</span>

    </a>
    <table id="placeDataTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Place Name</th>
            <th>Votes</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>Place Name</th>
            <th>Votes</th>
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
                <form class="form-horizontal" id="detailsForm" method="post" action="javascript:void(null);" onsubmit="call(this)">
                    <input type="hidden" id="placeId" name="placeId">
                    <div class="form-group">
                        <label for="placeName" class="control-label col-xs-3">Place Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="placeName" name="placeName"
                                   value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="votes" class="control-label col-xs-3">Who Prepared?</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="votes" name="votes" value="">
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


<script type="text/javascript" src="static/js/place.js" defer></script>
</body>
</html>