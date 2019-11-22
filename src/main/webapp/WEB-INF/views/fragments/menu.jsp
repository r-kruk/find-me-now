<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav>
    <div class="row ml-1 mr-1">
        <div class="col-11 float-left d-none d-md-block">
            <a href="/" class="btn btn-primary"><i class="fa fa-home"></i> Strona główna</a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary"><i class="fa fa-user"></i> Panel użytkownika</a>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="/admin-panel" class="btn btn-primary"><i class="fa fa-cogs"></i> Panel administratora</a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary"><i class="fa fa-question-circle-o"></i> Pomoc</a>
        </div>
        <div class="col-11 float-left d-block d-md-none">
            <a href="/" class="btn btn-primary"><i class="fa fa-home"></i></a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary"><i class="fa fa-user"></i></a>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="/admin-panel" class="btn btn-primary"><i class="fa fa-cogs"></i></a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary"><i class="fa fa-question-circle-o"></i></a>
        </div>
        <div class="col-1 float-right d-none d-md-block">
            <sec:authorize access="isAnonymous()">
                <a href="/login" class="btn btn-primary"><i class="fa fa-sign-in"></i> Zaloguj</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/logout" class="btn btn-primary"><i class="fa fa-sign-out"></i> Wyloguj</a>
            </sec:authorize>
        </div>
        <div class="col-1 float-right d-block d-md-none">
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
