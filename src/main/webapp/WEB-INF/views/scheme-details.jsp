<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Szczegóły schematu</title><meta charset="utf-8">
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
        <div class="col-12 text-center h3">${schemeDTO.name}</div>
    </div>
    <br>
    <div class="row">
        <div class="col-12 text-center h5">${schemeDTO.description}</div>
    </div>
    <br>
    <div class="row">
        <c:if test="${schemeDTO.active == true}">
            <div class="col-12 text-center h5">
                <span>Aktywny i widoczny</span>
                <br>
                <br>
                <a href="/admin-panel/deactivate-scheme?id=${schemeDTO.id}" class="btn btn-primary btn-sm">Ukryj</a>
            </div>
        </c:if>
        <c:if test="${schemeDTO.active == false}">
            <div class="col-12 text-center h5">
                <span>Nieaktywny i niewidoczny</span>
                <br>
                <br>
                <a href="/admin-panel/activate-scheme?id=${schemeDTO.id}" class="btn btn-primary btn-sm">Udostępnij</a>
            </div>
        </c:if>
    </div>
    <br>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10 text-center">
            <img src="/scheme?id=${schemeDTO.id}" class="img-fluid w-100" alt="Scheme">
            <div>
                <c:forEach items="${allPlaceDTOs}" var="place" varStatus="placeStatus">
                    <i class="fa fa-times"
                       style="color: yellow; position: absolute; left: ${place.coordinateX + 10}; top: ${place.coordinateY - 10}"></i>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
