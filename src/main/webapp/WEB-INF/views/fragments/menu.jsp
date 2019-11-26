<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav>
    <div class="row ml-1 mr-1">
        <div class="col-9 float-left d-none d-lg-block">
            <a href="/" class="btn btn-primary"><i class="fa fa-home"></i> Strona główna</a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary"><i class="fa fa-user"></i> Panel użytkownika</a>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="/admin-panel" class="btn btn-primary"><i class="fa fa-cogs"></i> Panel administratora</a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary"><i class="fa fa-question-circle-o"></i> Pomoc</a>
        </div>
        <div class="col-9 float-left d-block d-lg-none">
            <a href="/" class="btn btn-primary"><i class="fa fa-home"></i></a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary"><i class="fa fa-user"></i></a>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="/admin-panel" class="btn btn-primary"><i class="fa fa-cogs"></i></a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary"><i class="fa fa-question-circle-o"></i></a>
        </div>
        <sec:authorize access="isAuthenticated()">
            <div class="col-1"></div>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <div class="col-3 float-right d-none d-lg-block">
                <a href="/register" class="btn btn-primary"><i class="fa fa-pencil-square-o"></i> Zarejestruj</a>
                <a href="/login" class="btn btn-primary"><i class="fa fa-sign-in"></i> Zaloguj</a>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="col-1 float-right d-none d-lg-block">
                <a href="/logout" class="btn btn-primary"><i class="fa fa-sign-out"></i> Wyloguj</a>
            </div>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <div class="col-3 float-right d-block d-lg-none">
                <a href="/register" class="btn btn-primary"><i class="fa fa-pencil-square-o"></i></a>
                <a href="/login" class="btn btn-primary"><i class="fa fa-sign-in"></i></a>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="col-1 float-right d-block d-lg-none">
                <a href="/logout" class="btn btn-primary"><i class="fa fa-sign-out"></i></a>
            </div>
        </sec:authorize>
    </div>
    <hr>
</nav>
