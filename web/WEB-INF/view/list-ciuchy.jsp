<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
    <title>List Ciuchy</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CIUCHY</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Dodaj ciuch"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <input type="button" value="Menu"
               onclick="window.location.href='${pageContext.request.contextPath}/'; return false;"
               class="add-button"/>
        <table>
            <tr>
                <th>Nazwa</th>
                <th>Index</th>
                <th>Status</th>
                <th>Nr listu</th>
                <th>Wymiary paczki</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <c:forEach var="singleCiuch" items="${ciuchy}">
                <c:url var="updateLink" value="/ciuch/showFormForUpdate">
                    <c:param name="ciuchId" value="${singleCiuch.ciuchid}"/>
                </c:url>
                <c:url var="deleteLink" value="/ciuch/deleteCiuch">
                    <c:param name="ciuchId" value="${singleCiuch.ciuchid}"/>
                </c:url>

                <tr>
                    <td>${singleCiuch.nazwa}</td>
                    <td>${singleCiuch.index}</td>
                    <td>${singleCiuch.status.nazwa}</td>
                    <td>${singleCiuch.nrListu}</td>
                    <td>${singleCiuch.wymiaryPaczki}</td>
                    <td><a href="${updateLink}">Edit</a></td>
                    <td><a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure to delete this ciuch?'))) return false"
                    >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>









