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

    <div class="row" style="margin-top: 40px">
        <div class="col-1"></div>
        <div class="col-10" style="padding-bottom: 20px"><h2>Twoje dane</h2></div>
        <div class="col-1"></div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-3 text-left h4">Nazwa użytkownika</div>
        <div class="col-1"></div>
        <div class="col-3 text-left h3"> ${userDAO.username}</div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-3 text-left h4">Imię</div>
        <div class="col-1"></div>
        <div class="col-3 text-left h3"> ${userDAO.firstName}</div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-3 text-left h4">Nazwisko</div>
        <div class="col-1"></div>
        <div class="col-3 text-left h3"> ${userDAO.lastName}</div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-3 text-left h4">Uprawnienia</div>
        <div class="col-1"></div>
        <div class="col-3 text-left h3"> ${userDAO.role}</div>
    </div>

</div>
<div class="col-5"></div>
</div>
</div>
</body>
</html>
