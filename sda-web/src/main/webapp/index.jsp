<%@ page import="pl.sda.service.ArticleService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<main role="main" ng-app="articleApp">
    <%--    <%--%>
    <%--        ArticleService articleService = new ArticleService();--%>
    <%--        List articles=articleService.getArticles();--%>
    <%--        pageContext.setAttribute("articles",articles);--%>
    <%--    %>--%>
    <%--<c:forEach var = "article" items="${articles}" >--%>

    <%--    <div class="jumbotron">--%>
    <%--    <div class="container">--%>
    <%--        <h6 class="display-3">${article.getTitle()}</h6>--%>
    <%--        <p>${article.getContent()}</p>--%>
    <%--        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>--%>
    <%--    </div>--%>
    <%--</div>--%>
    <%--</c:forEach>--%>
<div ng-controller="articleController" ng-init="init()">
    <div ng-repeat="article in articles">
        <div class="jumbotron">
                <div class="container">
                    <p style="font-weight: bold">{{article.title}}</p>
                    <p>{{article.content}}</p>
                    <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
                    <br>
                    <p>dodał : {{article.user.login}}</p>
                </div>
            </div>
    </div>
</div>
</main>

<footer>
    <jsp:include page="/include/footer.jsp"/>
</footer>
<script src="${pageContext.request.contextPath}/js/angular.js"></script>
<script>
    var articleApp = angular.module('articleApp', []);
    articleApp.controller('articleController', function ($scope, $http) {
        $scope.init = function () {
            $http({
                method: 'GET',
                url: 'rest/articles',
                params: {}
            }).then(
                function (response) {
                    $scope.articles = response.data;
                }
            )
        }
    });

</script>

</body>
</html>
