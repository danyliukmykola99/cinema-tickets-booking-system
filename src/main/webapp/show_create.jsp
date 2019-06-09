<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mykola
  Date: 27.05.19
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Додавання сеансу</title>
</head>
<body>
<form name="show" action="/shows/create" method="post">
    <div class="form-group">
        <label for="movie">Фільм</label>
        <select id="movie" name="movieId">
            <c:forEach var="item" items="${movies}">
                <option value="${item.id}">${item.title}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="timeSlot">Початковий час</label>:
        <select id="timeSlot" name="startDateTime">
            <c:forEach var="item" items="${times}">
                <option value="${item}">${item}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Додати сеанс</button>
</form>
</body>
</html>
