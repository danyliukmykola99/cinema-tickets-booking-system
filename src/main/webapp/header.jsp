<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="danyliuk.mykola.model.domain.User" %>
<%
    boolean nonAuth,admin = false,client = false;
    Object o = session.getAttribute("user");
    nonAuth = o == null;
    if(o!=null){
        User u = (User) o;
        admin = u.isAdmin();
        client = u.isClient();
    }
    pageContext.setAttribute("nonAuthorized",nonAuth);
    pageContext.setAttribute("admin",admin);
    pageContext.setAttribute("client",client);
%>

<html lang="${sessionScope['language']}">
<body>
<div class="navbar navbar-light bg-light navbar-expand-md" role="navigation">

    <nav>
        <a href="/app/movies">Фільми</a>
    </nav>

    <nav>
        <a href="/app/shows">Сеанси</a>
    </nav>

    <c:if test="${admin}">
        <nav>
            <a href="/app/admin/movies">Фільми.Адміністрування</a>
        </nav>
    </c:if>

    <c:if test="${admin}">
        <nav>
            <a href="/app/admin/shows">Сеанси.Адміністрування</a>
        </nav>
    </c:if>

    <c:if test="${client}">
        <nav>
            <a href="/app/tickets">Квитки</a>
        </nav>
    </c:if>

    <c:if test="${nonAuthorized}">
        <nav>
            <a href="/login.jsp">Ввійти</a>
        </nav>
    </c:if>

    <c:if test="${nonAuthorized}">
        <nav>
            <a href="/register.jsp">Реєстрація</a>
        </nav>
    </c:if>

    <c:if test="${client||admin}">
        <nav>
            <a href="/app/logout">Вийти</a>
        </nav>
    </c:if>
</div>
</body>
</html>