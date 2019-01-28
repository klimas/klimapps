<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Article Form</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>
<body>
<div id="wrapper">
    <div id="cotnainer">
        <h2>Provide article details</h2>

        <form:form action="saveArticle" modelAttribute="article" method="POST">
            <form:hidden path="articleid"/>

            <table>
                <tbody>
                <tr>
                    <td><label>Article name:</label></td>
                    <td><label><form:input path="name"/></label></td>
                </tr>
                <tr>
                    <td><label>EAN:</label></td>
                    <td><label><form:input path="ean"/></label></td>
                </tr>
                <tr>
                    <td><label>Article internal name:</label></td>
                    <td><label><form:input path="internalName"/></label></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><label><input type="submit" value="Submit"/></label></td>
                </tr>

                </tbody>
            </table>
        </form:form>
        <div style="clear: both"></div>
        <p>
            <a href="${pageContext.request.contextPath}/article/list">Back to article list</a>
        </p>

    </div>

</div>
</body>
</html>
