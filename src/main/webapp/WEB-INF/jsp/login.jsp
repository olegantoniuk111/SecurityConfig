<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <fmt:setBundle basename="messages"/>
</head>
<body>

<div class="containeer">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
<div class="page-heading">
    <h1 class="panel title" align="left">Login with Username and Password</h1><br>
</div>
        <div class="panel body">

            <form:form class="form-inline" method="post" name="f">
                <div class="form-group">
                    <label for="username">username</label>
                    <input type="text" class="form-control" id="username" placeholder="username" name="username">
                </div>
            <br>
                <div class="form-group">
                    <label for="password">password</label>
                    <input type="password" class="form-control" id="password" placeholder="password" name="password">
                </div>
        </div>
                <c:if test="${error}">
                    <div class="alert alert-danger" role="alert"><spring:message code="message.badCredentials"/></div>
                </c:if>
                <c:if test="${logout}">
                    <div class="alert alert-info" role="alert"> <fmt:message key="message.logoutSucc"></fmt:message> </div>
                </c:if>
                <button type="submit" class="btn btn-default">Log in</button>
                <a href="/logout" class="btn btn-default">Logout</a>
            </form:form>

            </div>
        </div>
    </div>
</div>
error : ${error}<br>
logout ${logout}
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>