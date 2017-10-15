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
                   <th>Name</th>
                   <th>Votes</th>
               </tr>
               </thead>
            <tbody>
            <tr>
                <td class="placeName">  </td>
                <td class="placeVotes"> </td>
            </tr>
            </tbody>
           </table>
       </div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>