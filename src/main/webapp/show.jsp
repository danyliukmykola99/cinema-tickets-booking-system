<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${sessionScope['language']}"/>
<fmt:setBundle basename="repair_agency_localization"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${sessionScope['language']}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Сеанси</title>
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
    <c:import url="includes.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<main role="main">
    Назва фільму - ${show.movieTitle}
    Дата - ${show.startDate}
    Час - ${show.startTime}
    Кількість вільних квитків - ${show.availableTicketsCount}
    <div class="container marketing">
        <table border="1">
            <c:forEach items="${ticketMatrix.matrix}" var="ticketRow">
                <tr>
                    <c:forEach items="${ticketRow}" var="ticket">
                        <td>
                            <c:if test="${ticket.available}">
                                <a href="/tickets/create?show_id=${show.id}&seat=${ticket.seat}">
                                        ${ticket.seat}
                                </a>
                            </c:if>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

    </div>

</main>
</body>
</html>