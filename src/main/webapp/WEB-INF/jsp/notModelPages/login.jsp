
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<jsp:include page="../fragments/headTag.jsp"/>
<body>

<div class="container">

    <form method="POST" action="/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group">
            <span>  message </span>
            <input name = "username" type="text" class="form-control" placeholder="username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="/registration">Create an account</a></h4>
            <h3><a href=""></a>Enter as User</h3>
            <h3><a href=""></a>Enter as Admin</h3>
            <p>
                <a class="btn btn-lg btn-success" href="register"> registration </a>
                <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('regular', '12345678')">
                    Enter as User
                </button>
                <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('admin', '12345678')">
                    Enter as Admin
                </button>
            </p>
        </div>

    </form>

</div>
<!-- /container -->
<script type="text/javascript">

    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
    }
</script>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
