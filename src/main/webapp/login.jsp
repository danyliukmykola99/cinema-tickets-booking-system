<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="info" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope['language']}"/>
<fmt:setBundle basename="repair_agency_localization"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page - RepairAgency</title>
    <c:import url="includes.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<div id="login-overlay" class="modal-dialog modal-lg" style="z-index: 9999;">
    <div class="modal-content">
        <div class="modal-body">
            <div class="row">
                <div class="col-6">
                    <div class="card bg-light card-body mb-3">
                        <form action="${pageContext.request.contextPath}/app/login" method="post">
                            <div class="form-group">
                                <label for="email">Емейл</label>:
                                <input type="text"
                                       id="email"
                                       name="email"
                                       class="form-control"
                                       autofocus="autofocus"
                                       placeholder="Username"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Пароль</label>:
                                <input type="password"
                                       id="password"
                                       name="password"
                                       class="form-control"
                                       placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="mx-auto">
                                        <input type="submit"
                                               name="login-submit"
                                               id="login-submit"
                                               class="form-control btn btn-info"
                                               value="Ввійти"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-6">
                    <h3 class="row">
                        <a class="mx-auto badge badge-info" href="<c:url value="/register.jsp"/>">
                            Зареєструватись
                        </a>
                    </h3>
                    <h3 class="row">
                        <a class="mx-auto badge badge-light" href="<c:url value="/app/home"/>">
                            Головна
                        </a>
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="particles-js"></div>
</body>
</html>