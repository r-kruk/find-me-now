<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Panel użytkownika</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<jsp:include page="fragments/menu.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-1">
            <a href="/user-panel?tab=0" class="btn btn-primary float-right">Informacje</a>
            <br>
            <br>
            <a href="/user-panel?tab=1" class="btn btn-primary float-right">Rezerwacje</a>
        </div>
        <div class="col-1"></div>
        <div class="col-10 text-left">
            <c:if test="${activeTab == 0}">
                <br>
                <p class="h3">Nazwa uzytkownika: ${userDAO.username}</p>
                <br>
                <p class="h5">Imię: ${userDAO.firstName}</p>
                <p class="h5">Nazwisko: ${userDAO.lastName}</p>
                <br>
                <c:if test="${userDAO.role.equals('ROLE_USER')}">
                    <p class="h5">Uprawnienia: Użytkownik</p>
                </c:if>
                <c:if test="${userDAO.role.equals('ROLE_ADMIN')}">
                    <p class="h5">Uprawnienia: Administrator</p>
                </c:if>
                <br>
                <p class="h5">
                    <a href="/user-panel/deactivate-user?id=${userDAO.id}" class="btn btn-primary btn-sm">Wyłącz konto</a>
                    <br>
                    <span class="h6"> Uwaga: konto włączyć ponownie może tylko administrator!</span>
                </p>
            </c:if>
            <c:if test="${activeTab == 1}">
                <div class="h1 text-center">
                    Tu kiedyś będą rezerwacje użytkownika.
                    <br>
                    <br>
                    Jak zrobimy oczywiście. ;)
                </div>
            </c:if>
        </div>
    </div>
</div>
<%--<div class="container">--%>

<%--    <div class="row" style="margin-top: 40px">--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-10" style="padding-bottom: 20px"><h2>Twoje dane</h2></div>--%>
<%--        <div class="col-1"></div>--%>
<%--    </div>--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    <div class="row">--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h4">Nazwa użytkownika</div>--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h3"> ${userDAO.username}</div>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h4">Imię</div>--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h3"> ${userDAO.firstName}</div>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h4">Nazwisko</div>--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h3"> ${userDAO.lastName}</div>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h4">Uprawnienia</div>--%>
<%--        <div class="col-1"></div>--%>
<%--        <div class="col-3 text-left h3"> ${userDAO.role}</div>--%>
<%--    </div>--%>

<%--</div>--%>
<%--<div class="col-5"></div>--%>
<%--</div>--%>
<%--</div>--%>
</body>
</html>
