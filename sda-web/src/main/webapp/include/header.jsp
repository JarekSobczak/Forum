
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Główna</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/add-article.jsp">Dodaj wpis</a>
            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${sessionScope.user==null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Zaloguj się</a>
                    </c:when>
                    <c:otherwise><a class="nav-link" href="${pageContext.request.contextPath}/logout">Wyloguj się</a></c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>

</body>
</html>
