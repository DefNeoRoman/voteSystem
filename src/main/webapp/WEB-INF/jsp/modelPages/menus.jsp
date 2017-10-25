
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
            <th>Description</th>
            <th>Who prepared it?</th>
        </tr>
        </thead>
<div id ="forParsingJson">
    <c:forEach items="${menus}" var="menu">
        <jsp:useBean id="menu" scope="page" type="model.Menu"/>

    <tr>
        <form action="" id="menuForm">
             <input type="hidden" name="uuid" id="uuid" value="${menu.id}">
            <input type="hidden" name="name" id="name" value="${menu.name}">
            <td><c:out value="${menu.name}"/></td>
            <input type="hidden" name="cockName" id="cockName" value="${menu.cookName}">
            <td><c:out value="${menu.cookName}"/></td>
            <td>
                <a class="btn btn-primary" onclick="testEdit('${menu.id}')">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            </a>
            </td>
            <td>
                <a href="menus/delete/${menu.id}">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </a>
            </td>
        </form>

    </tr>
</div>

        <br>
    </c:forEach>
    </table>
    <a class="btn btn-primary" onclick="add()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        add
    </a>
</div>
<div class="modal fade" id="editRow">

    <c:set var = "sMenu" scope="page" value = "${singleMenu}"/>
    <jsp:useBean id="sMenu" scope="page" type="model.Menu"/>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="clear()">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm" action="menus/update" method="post">
                    <input type="hidden" id="editUuid" name="editUuid">
                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cName" class="control-label col-xs-3">Who prepared it</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="cName" name="cName">
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
<script type="text/javascript" src="static/js/menu.js" defer></script>
</body>
</html>