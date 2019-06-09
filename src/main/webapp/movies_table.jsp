<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mykola
  Date: 09.06.19
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<table>
    <c:forEach items="${schedule.movies}" var="movie">
        <tr>
            <td>${movie.title}</td>
            <c:forEach items="${movie.shows}" var="show">
                <td>
                    <a href="<c:url value="/shows?showId=${show.id}"/>">
                            ${show.startTime}
                    </a>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<hr/>
