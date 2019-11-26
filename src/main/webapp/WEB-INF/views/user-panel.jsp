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
     <div class="row">
        <div class="col-1"></div>
        <div class="col-6">
            <div class="col-12 text-center h3">${user.username}</div>
            <div class="col-12 text-center h3" href="/?id=${userDAO.username}"></div>
            <div class="col-12 text-center h3">${userDAO.lastName}</div>
            <form method="get" action="/register">
                <div class="form-group">
                    <label for="username">Nazwa użytkownika</label>
                    <input type="text" required name="username" id="username"/>
                </div>

                <div class="form-group">
                    <label for="firstName">Imię</label>
                    <input type="text" required name="firstName" id="firstName" class="form-control" placeholder="Podaj imię"/>
                </div>
                <div class="form-group">
                    <label for="lastName">Nazwisko</label>
                    <input type="text" required name="lastName" id="lastName" class="form-control" placeholder="Podaj nazwisko"/>
                </div>
                <button class="btn btn-primary" type="submit">Zaktulizuj</button>
                <button class="btn btn-secondary" type="reset">Usuń użytkownika</button>
                <sec:csrfInput/>
            </form>
        </div>
        <div class="col-5"></div>
    </div>
</div>
</body>
</html>
