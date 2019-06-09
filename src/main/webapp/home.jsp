<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${sessionScope['language']}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Фільми</title>
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
    <c:import url="includes.jsp"/>
</head>
<body>
<jsp:useBean id="weekSchedule" scope="request" type="danyliuk.mykola.model.dto.WeekScheduleDTO"/>
<c:import url="header.jsp"/>
<main role="main">
    <div class="container marketing">
        Сьогодні
        <c:set var="schedule" value="${weekSchedule.todaySchedule}" scope="request"/>
        <jsp:include page="movies_table.jsp"/>
        Завтра
        <c:set var="schedule" value="${weekSchedule.tomorrowSchedule}" scope="request"/>
        <jsp:include page="movies_table.jsp"/>
        <c:forEach items="${weekSchedule.nextFiveDaysSchedule}" var="daySchedule">
            ${daySchedule.date}
            <c:set var="schedule" value="${daySchedule}" scope="request"/>
            <jsp:include page="movies_table.jsp"/>
        </c:forEach>
    </div>
</main>
</body>
</html>