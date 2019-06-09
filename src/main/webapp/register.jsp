<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Реєстрація</title>
    <c:import url="/includes.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<div id="login-overlay" class="modal-dialog modal-lg" style="z-index: 9999;">
    <div class="modal-content">
        <div class="modal-body">
            <div class="row">
                <div class="col">
                    <div class="card bg-light card-body mb-3">
                        <form name="form" action="<c:url value="/register"/>" method="post">
                            <div class="form-group">
                                <label for="email" class="control-label">Емейл</label>
                                <input id="email" name="email" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label">Пароль</label>
                                <input id="password" name="password" class="form-control" type="password"/>
                            </div>
                            <div class="form-group row">
                                <button type="submit" class="mx-auto btn btn-success">
                                    <h2>Зареєструвати</h2></button>
                            </div>
                            <div class="form-group">
                                <h3 class="row">
                                    <a class="badge badge-info" href="<c:url value="/login"/>">
                                        Ввійти
                                    </a>
                                </h3>
                            </div>
                            <div class="form-group">
                                <h3 class="row">
                                    <a class="mx-auto badge badge-light" href="<c:url value="/"/>">
                                        Головна
                                    </a>
                                </h3>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="particles-js"></div>
</body>
</html>