
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>RegisterForm</title>
</head>
<body>
<h1> Register page</h1>

    <form:form action="register" method="post" modelAttribute="userDto">
        <form:input path="username" id="username" placeholder="username"/><br>
        <form:input path="lastName" id="lastName" placeholder="lastName"/><br>
        <form:input path="password" id="password" placeholder="password"/><br>
        <form:input path="matchingPassword" id="matchingPassword" placeholder="matchingPassword"/><br>
        <form:input path="email" id="email" placeholder="email"/><br>
        <form:errors ></form:errors>
        <input type="submit" value="submit"/>
    </form:form>
</body>
</html>
