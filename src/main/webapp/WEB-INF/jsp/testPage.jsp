<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <title>getAllPokemons</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
Hello ${username}!!!<br>
Your registered as :
<c:forEach items="${roles}" var="role">
    ${role}
</c:forEach>
<h2>Welcome to our resource</h2>

<a href="/gansApp">to main page</a>



</body>

</html>