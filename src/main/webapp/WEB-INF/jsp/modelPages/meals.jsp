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
               <th>Price</th>
           </tr>
           </thead>
           <c:forEach items="${meals}" var="meal">
               <jsp:useBean id="meal" scope="page" type="model.Meal"/>

               <tr>

                   <td><c:out value="${meal.name}"/></td>
                   <td><c:out value="${meal.price}"/></td>
                   <td>
                       <button type="button" class="btn btn-default" onclick="edit('${meal.name}',${meal.price})">
                           Edit
                       <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                       </button>
                   </td>
                   <td><a href="meals/delete?uuid=${meal.uuid}">
                       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                   </a></td>
               </tr>
               <br>
           </c:forEach>
       </table>


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
</body>
</html>