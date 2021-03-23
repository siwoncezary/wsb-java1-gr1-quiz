<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/quiz">
    <label for="question">Treść pytania</label>
    <input name="question" id="question" type="text"/><br>
    <c:forEach var="number" begin="0" end="4">
        <label for=${number}>Opcja odpowiedzi</label><br>
        <input name="options" id=${number} type="text">
        <input type="checkbox" name="answers" value=${number}><br>
    </c:forEach>
    <input type="submit" value="Zapisz"/>
</form>
</body>
</html>