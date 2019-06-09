<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="${sessionScope['language']}">
<body>
<div class="navbar navbar-light bg-light navbar-expand-md" role="navigation">

    <nav>
        <a href="<c:url value="/"/>">Сеанси</a>
    </nav>

    <sec:authorize access="hasRole('ADMIN')">
        <nav>
            <a href="/admin/movies">Фільми.Адміністрування</a>
        </nav>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <nav>
            <a href="/admin/shows">Сеанси.Адміністрування</a>
        </nav>
    </sec:authorize>

    <sec:authorize access="hasRole('CLIENT')">
        <nav>
            <a href="/tickets">Квитки</a>
        </nav>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <nav>
            <a href="/login">Ввійти</a>
        </nav>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <nav>
            <a href="/register">Реєстрація</a>
        </nav>
    </sec:authorize>

    <sec:authorize access="hasAnyRole('ADMIN','CLIENT')">
        <nav>
            <a href="/logout">Вийти</a>
        </nav>
    </sec:authorize>

</div>
</body>
</html>