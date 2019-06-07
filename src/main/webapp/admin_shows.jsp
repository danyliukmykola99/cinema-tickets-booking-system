<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${sessionScope['language']}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Адміністраторська. Сеанси</title>
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    <div class="container marketing">

        <div>
            <a href="/shows/create">
                <button type="button">Додати сеанс</button>
            </a>
        </div>
        <table>
            <tr>
                <th scope="col">Назва фільму</th>
                <th scope="col">Дата</th>
                <th scope="col">Час</th>
                <th scope="col">Статус</th>
                <th scope="col">Продано квитків</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${shows}" var="show">
                <tr>
                    <td>${show.movieTitle}</td>
                    <td>${show.startDate}</td>
                    <td>${show.startTime}</td>
                    <td>${show.status}</td>
                    <td>${show.reservedTicketsCount}</td>
                    <td>
                        <a href="/shows/cancel?showId=${show.id}">
                            Скасувати сеанс
                        </a>
                    </td>
                    <td>
                        <a href="/shows/start?showId=${show.id}">
                            Старт сеансу
                        </a>
                    </td>
                    <td>
                        <a href="/shows/finish?showId=${show.id}">
                            Кінець сеансу
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>

</main>
</body>
</html>