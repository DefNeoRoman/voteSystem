<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="../fragments/headTag.jsp"/>
<body>

<div class="container">

    <form method ="post" class="form-horizontal postForm" id="registerForm" action="javascript:void(null);" onsubmit="call(this)" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <%--for userName--%>
        <div class="form-group">
            <label for="name" class="control-label col-xs-3">Name</label>

            <div class="col-xs-9">
                <input type="text" class="form-control" id="name" name="name">
            </div>
        </div>
        <%--for userEmail--%>
        <div class="form-group">
            <label for="email" class="control-label col-xs-3">Email</label>

            <div class="col-xs-9">
                <input type="text" class="form-control" id="email" name="email">
            </div>
        </div>
        <%--for password--%>
        <div class="form-group">
            <label for="email" class="control-label col-xs-3">Password</label>

            <div class="col-xs-9">
                <input type="text" class="form-control" id="password" name="password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input class="btn btn-primary" type="submit" value="save">
                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>

            </div>
        </div>
    </form>
   <h2><a href="/login">go Back</a></h2>
</div>
<!-- /container -->
<jsp:include page="../fragments/footer.jsp"/>
<script type="text/javascript" src="static/js/register.js" defer></script>
</body>
</html>