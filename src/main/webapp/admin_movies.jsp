<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page. Movies</title>
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    <div class="container marketing">

        <div>
            <a href="<c:url value="/movies/create"/>">
                <button type="button">Додати фільм</button>
            </a>
        </div>
        <table>
            <tr>
                <th scope="col">Назва</th>
                <th scope="col">Опис</th>
                <th scope="col">Продано квитків</th>
                <th></th>
            </tr>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.description}</td>
                    <td>${movie.reservedTicketsCount}</td>
                    <td>
                        <a href="<c:url value="/movies/cancel?movieId=${movie.id}"/>">
                            Скасувати всі сеанси
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>

</main>
</body>
</html>