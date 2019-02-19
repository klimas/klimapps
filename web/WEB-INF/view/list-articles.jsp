<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
    <title>List Articles</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>ARTICLE LIST</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add article"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <table>
            <tr>
                <th>Article Name</th>
                <th>EAN</th>
                <th>Internal name</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <c:forEach var="storedArticle" items="${articles}">
                <c:url var="updateLink" value="/article/showFormForUpdate">
                    <c:param name="articleId" value="${storedArticle.articleid}"/>
                </c:url>
                <c:url var="deleteLink" value="/article/deleteArticle">
                    <c:param name="articleId" value="${storedArticle.articleid}"/>
                </c:url>

                <tr>
                    <td>${storedArticle.name}</td>
                    <td>${storedArticle.ean}</td>
                    <td>${storedArticle.internalName}</td>
                    <td><a href="${updateLink}">Edit</a></td>
                    <td><a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure to delete this article?'))) return false"
                    >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>









