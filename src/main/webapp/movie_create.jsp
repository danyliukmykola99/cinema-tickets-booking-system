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
    <title>Додавання фільму</title>
</head>
<body>
<form action="/movies/create" method="post">
    <div class="form-group">
        <label for="title">Назва</label>:
        <input class="form-control" name="title" id="title"/>
    </div>
    <div class="form-group">
        <label for="description">Опис</label>:
        <input class="form-control" name="description" id="description"/>
    </div>
    <button type="submit">Додати фільм</button>
</form>
</body>
</html>
