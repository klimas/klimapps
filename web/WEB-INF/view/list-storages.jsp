<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
    <title>List Storages</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>STORAGE LIST</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add storage"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <table>
            <tr>
                <th>Storage Name</th>
                <th>Localization</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <c:forEach var="storage" items="${storages}">
                <c:url var="updateLink" value="/storage/showFormForUpdate">
                    <c:param name="storageId" value="${storage.storageid}"/>
                </c:url>
                <c:url var="deleteLink" value="/storage/deleteStorage">
                    <c:param name="storageId" value="${storage.storageid}"/>
                </c:url>

                <tr>
                    <td>${storage.storageName}</td>
                    <td>${storage.localization}</td>
                    <td><a href="${updateLink}">Edit</a></td>
                    <td><a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure to delete this storage?'))) return false"
                    >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>









