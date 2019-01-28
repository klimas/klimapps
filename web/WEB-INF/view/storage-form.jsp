<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Storage Form</title>
</head>
<body>
<h2>Please give your name</h2>

<form:form action="processForm" modelAttribute="storage">
    Storage name: <form:input path="storageName"/>
    <br><br>
    Localization: <form:input path="localization"/>
    <br><br>

    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
