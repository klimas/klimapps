<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Import Allegro CSV file</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>IMPORT DATA FROM CSV</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <%--<center>--%>
        <h1>Upload File Form</h1>
        <form action="FileUploadHandler" enctype="multipart/form-data" method="post">
            Enter File Name <input type="text" name="file_name"><br>
            Select <input type="file" name="file2"/><br>
            <input type="submit" value="upload"/>
        </form>
        <%
            String file_name = (String) request.getParameter("filename");
            if (file_name != null) {
                out.println(file_name + " File uploaded successfuly");
            }
        %>
        <%--</center>--%>
    </div>
</div>
</body>

</html>









