<%@ page import="pl.sda.service.ArticleService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">
<head>
   <jsp:include page="/include/meta.jsp"/>
    <title>FORUM : home page</title>
</head>

<body>

<header>
    <jsp:include page="/include/header.jsp"/>
</header>

<main role="main">
    <%
        ArticleService articleService = new ArticleService();
        List articles=articleService.getArticles();
        pageContext.setAttribute("articles",articles);
    %>
<c:forEach var = "article" items="${articles}" >

    <div class="jumbotron">
    <div class="container">
        <h5 class="display-3">${article.getTitle()}</h5>
        <p>${article.getContent()}</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
    </div>
</div>
</c:forEach>
</main>

<footer >
    <jsp:include page="/include/footer.jsp"/>
</footer>
</body>
</html>
