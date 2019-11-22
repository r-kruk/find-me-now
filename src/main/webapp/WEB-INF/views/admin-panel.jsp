<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Panel administratora</title><meta charset="utf-8">
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
        <div class="col-12 text-center">
            <a href="/admin-panel/add-scheme" class="btn btn-primary">Dodaj schemat</a>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-12">
            <table class="table table-hover table-bordered text-center">
                <thead>
                    <tr class="thead-dark">
                        <th>Lp.</th>
                        <th>Nazwa</th>
                        <th>Szczegóły</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><a href="#" class="btn btn-primary btn-sm">Zobacz</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
