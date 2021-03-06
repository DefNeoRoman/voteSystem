<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" xmlns:jsp="http://java.sun.com/JSP/Page">

<jsp:include page="../fragments/headTag.jsp"/>
<body>

<div class="container">

    <form class="navbar-form" action="${contextPath}/login" method="post">
        <h2 class="form-heading">Place Manager</h2>
        <div class="col-md-3">

        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input name="username" type="text" class="form-control" placeholder="username" id="username"
                       autofocus="true"/>
                <input id="password" name="password" type="password" class="form-control" placeholder="Password"/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <c:if test="${error}">
                    <div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
                </c:if>
                <c:if test="${logout}">
                    <div class="alert alert-info" role="alert">You've been logged out successfully.</div>
                </c:if>


                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                <p class="button-group">
                    <a class="btn btn-lg btn-success" onclick="add()"> registration </a>
                    <button type="submit" class="btn btn-lg btn-primary"
                            onclick="setCredentials('regular', '12345678')">
                        Enter as User
                    </button>
                    <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('admin', '12345678')">
                        Enter as Admin
                    </button>
                </p>
            </div>
        </div>
        <div class="col-md-3"></div>
    </form>


</div>
<div class="container">
    <p class="lead">Стек технологий: <a href="http://projects.spring.io/spring-security/">Spring Security</a>,
        <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring MVC</a>,
        <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>,
        <a href="http://spring.io/blog/2014/05/07/preview-spring-security-test-method-security">Spring Security
            Test</a>,
        <a href="http://hibernate.org/orm/">Hibernate ORM</a>,
        <a href="http://hibernate.org/validator/">Hibernate Validator</a>,
        <a href="http://www.slf4j.org/">SLF4J</a>,
        <a href="https://github.com/FasterXML/jackson">Json Jackson</a>,
        <a href="http://ru.wikipedia.org/wiki/JSP">JSP</a>,
        <a href="http://en.wikipedia.org/wiki/JavaServer_Pages_Standard_Tag_Library">JSTL</a>,
        <a href="http://tomcat.apache.org/">Apache Tomcat</a>,
        <a href="http://www.webjars.org/">WebJars</a>,
        <a href="http://datatables.net/">DataTables plugin</a>,
        <a href="http://ehcache.org">EHCACHE</a>,
        <a href="http://www.postgresql.org/">PostgreSQL</a>,
        <a href="http://junit.org/">JUnit</a>,
        <a href="http://hamcrest.org/JavaHamcrest/">Hamcrest</a>,
        <a href="http://jquery.com/">jQuery</a>,
        <a href="http://ned.im/noty/">jQuery notification</a>,
        <a href="http://getbootstrap.com/">Bootstrap</a>.</p>
</div>
<div class="container">
    <div class="lead">
        Проект с регистрацией/авторизацией и интерфейсом на основе ролей (USER, ADMIN).
        Администратор может создавать/редактировать/удалять пользователей,меню,еду, рестораны, а администратор -
        управлять своим
        профилем и данными (меню, еда, рестораны) через UI (по AJAX) и по REST интерфейсу с базовой авторизацией.

        Весь REST интерфейс покрывается JUnit тестами, используя Spring MVC Test и Spring Security Test.
    </div>
</div>
</div>
<!-- /container -->
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="clear()">&times;
                </button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form method="post" class="form-horizontal postForm" id="detailsForm" action="javascript:void(null);"
                      onsubmit="call(this)">
                    <input type="hidden" id="id" name="id">


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
                            <input type="text" class="form-control" id="pass" name="password">
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
<script type="text/javascript">

    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
    }
</script>
<jsp:include page="../fragments/footer.jsp"/>
<script type="text/javascript" src="static/js/register.js" defer></script>
</body>
</html>
