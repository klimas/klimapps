<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article Confirmation</title>
</head>
<body>
<h2>Confirmation</h2>

The article is confirmed: ${article.name} with EAN: ${article.ean}

<div style="clear: both"></div>
<p>
    <a href="${pageContext.request.contextPath}/article/list">Back to article list</a>
</p>

</body>
</html>
