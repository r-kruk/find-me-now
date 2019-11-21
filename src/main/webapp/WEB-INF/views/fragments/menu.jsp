<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav>
    <div class="row ml-1 mr-1">
        <div class="col-md-11 col-sm-8">
            <a href="/" class="btn btn-primary">Strona główna</a>
            <sec:authorize access="isAuthenticated()">
                <a href="/user-panel" class="btn btn-primary">Panel użytkownika</a>
            </sec:authorize>
            <a href="/help" class="btn btn-primary">Pomoc</a>
        </div>
        <div class="col-md-1 col-sm-4">
            <sec:authorize access="isAnonymous()">
                <a href="/login" class="btn btn-primary">Zaloguj</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/logout" class="btn btn-primary">Wyloguj</a>
            </sec:authorize>
        </div>
    </div>
    <hr>
</nav>
