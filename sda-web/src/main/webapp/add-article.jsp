<%@ page contentType="text/html;charset=UTF-8"%>

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
<main role=""main>

    <div class="row text-center">
        <div class="col-md-8 m-auto text-left">
            <h4 class="mb-3">Dodaj nowy wpis</h4>
            <form name="addArticleForm" class="needs-validation" action="addArticle" method="post">
                <div class="mb-3">
                    <label for="title">Tytuł</label>
                    <input type="text" class="form-control" name="title" id="title" placeholder="Tytuł" required="">
                </div>
                <div class="mb-3">
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Example textarea</label>
                        <textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="3"></textarea>
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
            </form>
        </div>
    </div>


</main>
<footer >
    <jsp:include page="/include/footer.jsp"/>
</footer>
</body>
</html>
