<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Ciuch Form</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>
<body>
<div id="wrapper">
    <div id="cotnainer">
        <h2>Wprowadź nowy ciuch</h2>

        <form:form action="saveCiuch" modelAttribute="ciuch" method="POST">
            <form:hidden path="ciuchid"/>

            <table>
                <tbody>
                <tr>
                    <td><label>Nazwa:</label></td>
                    <td><label><form:input path="nazwa"/></label></td>
                </tr>
                <tr>
                    <td><label>Index:</label></td>
                    <td><label><form:input path="index"/></label></td>
                </tr>
                <tr>
                    <td><label>Status:</label></td>
                    <td><label><form:input path="status"/></label></td>
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
            <a href="${pageContext.request.contextPath}/ciuch/list">Wróć do listy ciuchów</a>
        </p>

    </div>

</div>
</body>
</html>
