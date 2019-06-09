<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${sessionScope['language']}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Квитки</title>
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    <div class="container marketing">
        <table>
            <tr>
                <th scope="col">Назва фільму</th>
                <th scope="col">Дата</th>
                <th scope="col">Час</th>
                <th scope="col">Місце</th>
            </tr>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>${ticket.movieTitle}</td>
                    <td>${ticket.showData}</td>
                    <td>${ticket.showTime}</td>
                    <td>${ticket.seat}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>