<%@page language="java" contentType="text/html"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/answer">
    <input name="id" value="${id}" hidden>
    <p>${question}</p> <br>
    <c:forEach items="${options}" var="option">
       <p>${option}<p>
        <input type="checkbox" value='${option}' name="answers"> <br>
    </c:forEach>
    <input type="submit" value="Zapisz"/>
</form>
</body>
</html>