<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/500.css"/>
    <c:import url="includes.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h2>Помилка сервера</h2>
                <div class="alert alert-danger">
                    ${errorMessage}
                </div>
                <div class="error-actions">
                    <a href="<c:url value="/"/>" class="btn btn-primary btn-lg"><span
                            class="fa fa-home"></span>
                        Повернутись на головну </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>