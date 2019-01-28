<%--
  Created by IntelliJ IDEA.
  User: mkl
  Date: 26-12-2018
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<h2>Please give your name</h2>

<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:

    <form:select path="country">
        <form:options items="${student.countries}"/>
    </form:select>
    <br><br>
    Favourite language:

    <form:radiobutton path="favoriteLanguage" value="Java"/>Java <br>
    <form:radiobutton path="favoriteLanguage" value="C#"/>C# <br>
    <form:radiobutton path="favoriteLanguage" value="PHP"/>PHP <br>
    <form:radiobutton path="favoriteLanguage" value="Scala"/>Scala <br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
