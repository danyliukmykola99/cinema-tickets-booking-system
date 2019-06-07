<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <div class="container marketing">
        <table>
            <tr>
                <th scope="col">Назва фільму</th>
                <th scope="col">Дата</th>
                <th scope="col">Час</th>
                <th scope="col">Кількість вільних квитків</th>
                <th scope="col"></th>
            </tr>
            <c:forEach items="${shows}" var="show">
                <tr>
                    <td>${show.movie.title}</td>
                    <td>${show.start.toLocalDate()}</td>
                    <td>${show.start.toLocalTime()}</td>
                    <td>${show.availableCount()}</td>
                    <td>
                        <a href="/app/show?show_id=${show.id.toString()}">
                            Переглянути місця
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>

</main>
</body>
</html>