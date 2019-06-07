<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="auth" uri="/authtags" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<fmt:setLocale value="${sessionScope['language']}"/>
<fmt:setBundle basename="repair_agency_localization"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${sessionScope['language']}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Квитки</title>
    <link rel="stylesheet" href="<c:url value="/static/css/home.css"/>"/>
    <c:import url="includes.jsp"/>
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
            <jsp:useBean id="user" scope="request" type="danyliuk.mykola.model.entities.User"/>
            <c:forEach items="${user.tickets}" var="ticket">
                <tr>
                    <td>${ticket.show.movie.title}</td>
                    <td>${ticket.show.time.date}</td>
                    <td>${ticket.show.time.timeSlot.startTime}</td>
                    <td>${ticket.seat}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

</main>
</body>
</html>