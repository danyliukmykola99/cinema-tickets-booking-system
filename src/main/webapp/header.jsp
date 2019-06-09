<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="${sessionScope['language']}">
<link rel="stylesheet" href="<c:url value="/css/header.css"/>"/>
<body>
<div role="navigation">

    <ul>

    <li>
        <a href="<c:url value="/"/>">Сеанси</a>
    </li>

    <sec:authorize access="hasRole('ADMIN')">
        <li>
            <a href="/admin/movies">Фільми.Адміністрування</a>
        </li>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <li>
            <a href="/admin/shows">Сеанси.Адміністрування</a>
        </li>
    </sec:authorize>

    <sec:authorize access="hasRole('CLIENT')">
        <li>
            <a href="/tickets">Квитки</a>
        </li>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <li style="float:right">
            <a href="/login">Ввійти</a>
        </li>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <li style="float:right">
            <a href="/register">Реєстрація</a>
        </li>
    </sec:authorize>

    <sec:authorize access="hasAnyRole('ADMIN','CLIENT')">
        <li style="float:right">
            <a href="/logout">Вийти</a>
        </li>
    </sec:authorize>

    </ul>

</div>
</body>
</html>