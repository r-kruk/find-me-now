<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Find me now!</title>
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
        <c:if test="${allActiveSchemeDAOs.size() == 0}">
            <div class="col-12 display-4 text-center">Baza danych nie zawiera aktywnych schematów!</div>
        </c:if>
        <c:if test="${allActiveSchemeDAOs.size() > 0}">
            <div class="col-1">
                <c:forEach items="${allActiveSchemeDAOs}" var="schemeDAO" varStatus="schemeDAOStatus">
                    <a href="/?id=${schemeDAO.id}" class="btn btn-primary float-right">${schemeDAO.name}</a>
                    <br>
                    <br>
                </c:forEach>
            </div>
            <div class="col-1"></div>
            <div class="col-10 h1 text-center">
                <form method="post" action="/">
                    <div class="form-row">
                        <div class="col-11 form-group">
                            <input type="text" required name="search" id="search" class="form-control"
                                   placeholder="Podaj nazwisko"/>
                        </div>
                        <div class="col-1 form-group">
                            <button class="btn btn-primary" type="submit">Szukaj</button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form>
                <c:if test="${visibleSchemeId == 0}">
                    <img src="/scheme?id=${allActiveSchemeDAOs.get(0).id}" class="img-fluid" alt="Scheme">
                </c:if>
                <c:if test="${visibleSchemeId != 0}">
                    <img src="/scheme?id=${visibleSchemeId}" class="img-fluid" alt="Scheme">
                </c:if>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
