<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav>
    <div class="row ml-1 mr-1">
        <div class="col-11 d-none d-sm-block">
            <a href="/" class="btn btn-primary">Strona główna</a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary">Panel użytkownika</a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary">Pomoc</a>
        </div>
        <div class="col-10 d-block d-sm-none">
            <a href="/" class="btn btn-primary"><i class="fa fa-home"></i></a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary"><i class="fa fa-user"></i></a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary"><i class="fa fa-question"></i></a>
        </div>
        <div class="col-1 d-none d-sm-block">
            <sec:authorize access="isAnonymous()">
                <a href="/login" class="btn btn-primary">Zaloguj</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/logout" class="btn btn-primary">Wyloguj</a>
            </sec:authorize>
        </div>
        <div class="col-2 d-block d-sm-none">
            <sec:authorize access="isAnonymous()">
                <a href="/login" class="btn btn-primary"><i class="fa fa-sign-in"></i></a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/logout" class="btn btn-primary"><i class="fa fa-sign-out"></i></a>
            </sec:authorize>
        </div>
    </div>
    <hr>
</nav>
