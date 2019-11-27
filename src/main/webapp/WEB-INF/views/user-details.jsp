<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Szczegóły użytkownika</title><meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<jsp:include page="fragments/menu.jsp"/>
<div class="container">
    <br>
    <div class="row">
        <div class="col-12 text-center h3">${userDAO.username}</div>
    </div>
    <br>
    <div class="row">
        <div class="col-12 text-center h5">${userDAO.firstName}</div>
    </div>
    <br>
    <div class="row">
        <div class="col-12 text-center h5">${userDAO.lastName}</div>
    </div>
    <br>
<%--    <div class="row">--%>
<%--        <c:if test="${userDAO.active == true}">--%>
<%--            <div class="col-12 text-center h5">--%>
<%--                <span>Aktywny i widoczny</span>--%>
<%--                <br>--%>
<%--                <a href="/admin-panel/deactivate-user?id=${userDAO.id}" class="btn btn-primary btn-sm">Wyłącz</a>--%>
<%--            </div>--%>
<%--        </c:if>--%>
<%--        <c:if test="${userDAO.active == false}">--%>
<%--            <div class="col-12 text-center h5">--%>
<%--                <span>Nieaktywny i niewidoczny</span>--%>
<%--                <br>--%>
<%--                <a href="/admin-panel/activate-user?id=${userDAO.id}" class="btn btn-primary btn-sm">Włącz</a>--%>
<%--            </div>--%>
<%--        </c:if>--%>
<%--    </div>--%>
</div>
</body>
</html>
