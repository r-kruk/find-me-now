<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav>
    <div class="row ml-1">
        <div class="col-11">
            <a href="/" class="btn btn-primary">Strona główna</a>
            <a href="/user-panel" class="btn btn-primary">Panel użytkownika</a>
            <a href="/help" class="btn btn-primary">Pomoc</a>
        </div>
        <div class="col-1">
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
