<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pomoc</title>
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
            <a href="/help?tab=0" class="btn btn-primary float-right">O programie</a>
            <br>
            <br>
            <a href="/help?tab=1" class="btn btn-primary float-right">Jak używać?</a>
        </div>
        <div class="col-1"></div>
        <div class="col-10 text-left">
            <c:if test="${tabNumber == 0}">
                <div class="h1">
                    <i class="fa fa-users"></i>Find me now!
                </div>
                <br>
                <br>
                <div class="h3">
                    Aplikacja służy do zarządzania miejscami w organizacji. Umożliwia również odnalezienie pracownika,
                    jeżeli ten wykorzystuje któreś z zarządzanych w aplikacji miejsc.
                </div>
            </c:if>
            <c:if test="${tabNumber == 1}">
                <div class="h1">
                    <i class="fa fa-users"></i>Find me now!
                </div>
                <br>
                <br>
                <div class="h3">
                    Jak najdłużej. ;)
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
