<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
    <title>List Articles in Storages</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>STOREDARTICLE LIST</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add article to storage"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <table>
            <tr>
                <th>Article</th>
                <th>Storage</th>
                <th>Purchase price</th>
                <th>Amount</th>
                <th>Date in</th>
                <th>Date out</th>
                <%--                <th>Edit</th>
                                <th>Remove</th>--%>
            </tr>
            <c:forEach var="storedArticle" items="${storedarticles}">
                <%--                <c:url var="updateLink" value="/article/showFormForUpdate">
                                    <c:param name="articleId" value="${tempArticle.articleid}"/>
                                </c:url>
                                <c:url var="deleteLink" value="/article/deleteArticle">
                                    <c:param name="articleId" value="${tempArticle.articleid}"/>
                                </c:url>--%>

                <tr>
                    <td>${storedArticle.article.articleName}</td>
                    <td>${storedArticle.storage.storageName}</td>
                    <td>${storedArticle.purchasePrice}</td>
                    <td>${storedArticle.amount}</td>
                    <td>${storedArticle.dateIn}</td>
                    <td>${storedArticle.dateOut}</td>

                        <%--                    <td><a href="${updateLink}">Edit</a></td>
                                            <td><a href="${deleteLink}"
                                                   onclick="if(!(confirm('Are you sure to delete this article?'))) return false"
                                            >Delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>









