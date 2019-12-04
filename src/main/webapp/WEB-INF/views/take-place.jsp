<%--
  Created by IntelliJ IDEA.
  User: lafar
  Date: 03.12.2019
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rezerwacja miejsca</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<jsp:include page="fragments/menu.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-12 text-center h1">Wybierz miejsce, które chcesz zająć</div>
        <c:if test="${allActiveSchemeDTOS.size() == 0}">
            <div class="col-12 display-4 text-center">Baza danych nie zawiera aktywnych schematów!</div>
        </c:if>
    </div>
    <br>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-8 h3 text-center">
            <form method="post" action="/?id=${visibleSchemeId}">
                <div class="form-row">
                    <div class="col-3 form-group">
                        <select required name="freePlace">
                            <c:forEach items="${availablePlaceDTOS}" var="placeDTO">
                            <option value="${placeDTO.name}">${placeDTO.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-1 form-group">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i> Pokaż</button>
                    </div>
                    <div class="col-2 form-group">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i> Zajmij</button>
                    </div>
                </div>
             <sec:csrfInput/>
            </form>
          </div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <c:if test="${allActiveSchemeDTOS.size() > 0}">
                <div class="col-1">
                <c:forEach items="${allActiveSchemeDTOS}" var="schemeDTO" varStatus="schemeDAOStatus">
                    <a href="/user-panel/take-place?id=${schemeDTO.id}"
                       class="btn btn-primary float-right">${schemeDTO.name}</a>
                    <br>
                    <br>
                </c:forEach>
            </div>
            <div class="col-8 text-center">
                <c:if test="${visibleSchemeId == 0}">
                    <img src="/scheme?id=${allActiveSchemeDTOS.get(0).id}" class="img-fluid w-100" alt="Scheme">
                </c:if>
                <c:if test="${visibleSchemeId != 0}">
                    <img src="/scheme?id=${visibleSchemeId}" class="img-fluid w-100" alt="Scheme">
                </c:if>
                <div>
                    <c:forEach items="${availablePlaceDTOS}" var="place">
                        <span>
                        <i class="fa fa-times"
                           style="color: yellow; position: absolute; left: ${place.coordinateX + 10}; top: ${place.coordinateY - 10}"> ${place.name}</i>
                            </span>
                    </c:forEach>
                </div>
            </div>
            <div class="col-1"></div>
        </c:if>
    </div>

</div>
</body>
</html>
