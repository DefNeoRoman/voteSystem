<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<jsp:include page="../fragments/headTag.jsp"/>
<body>
<jsp:include page="../fragments/header.jsp"/>
       <div class="container">
          <div id="forPlaces">

          </div>
       </div>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="clear()">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form method ="post" class="form-horizontal postForm" id="detailsForm" action="javascript:void(null);" onsubmit="call(this)" >
                    <input type="hidden" id="pUuid" name="pUuid">
                    <div class="form-group">
                        <label for="pName" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="pName" name="pName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pInput" class="control-label col-xs-3">Votes</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="pInput" name="quantity">
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

<script type="text/javascript" src="static/js/button.js" defer></script>
<script type="text/javascript" src="static/js/place.js" defer></script>
</body>
</html>