<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Assign article to the storage</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>
<body>
<div id="wrapper">
    <div id="cotnainer">
        <h2>Provide article details</h2>
        <form:errors path="storedarticle.*"/>
        <form:form action="saveStoredarticle" modelAttribute="storedarticle" method="POST">
            <%--<form:hidden path="storedarticleid"/>--%>

            <table>
                <tbody>
                <tr>
                    <td><label>Storage Id:</label></td>
                        <%--                        &lt;%&ndash;<td><label>Main</label></td>&ndash;%&gt;
                                            <td><label><form:input value="1" path="storage.storageid"/></label></td>--%>
                    <td><form:select path="storage.storageid">
                        <%--<form:option value="0" label="Select"/>--%>
                        <form:options items="${storages}" itemValue="storageid" itemLabel="storageName"/>
                    </form:select>
                    </td>
                </tr>
                <tr>
                    <td><label>Article:</label></td>
                    <td><form:select path="article.articleid">
                        <form:option value="0" label="Select"/>
                        <form:options items="${articles}" itemValue="articleid" itemLabel="articleName"/>
                    </form:select>
                    </td>
                </tr>
                <tr>
                    <td><label>Amount:</label></td>
                    <td><label><form:input path="amount"/></label></td>
                </tr>
                <tr>
                    <td><label>Purchase price:</label></td>
                    <td><label><form:input path="purchasePrice"/></label></td>
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
            <a href="${pageContext.request.contextPath}/storedarticle/list">Back to storedarticle list</a>
        </p>

    </div>

</div>
</body>
</html>
