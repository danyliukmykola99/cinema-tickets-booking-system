<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope['language']}"/>
<fmt:setBundle basename="repair_agency_localization"/>
<html>
<head>
    <title>Page Not Found - RepairAgency</title>
    <c:import url="WEB-INF/fragment/includes.jsp"/>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/404.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h2>404 Не знайдено</h2>
                <div class="error-actions">
                    <a href="${pageContext.request.contextPath}/app/home" class="btn btn-primary btn-lg"><span
                            class="fa fa-home"></span>
                        Повернутись на головну</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
