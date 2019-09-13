<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Wyslij na magazyn</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-form-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Artykuly przygotowane</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>Nazwa</th>
                <th>Index</th>
                <th>Status</th>
                <th>Wymiary paczki</th>
                <th>Dodaj do zamówienia</th>
                <%--                <th>Remove</th>--%>
            </tr>
            <c:forEach var="singleCiuch" items="${ciuchyPrzygotowane}">
                <c:url var="dodajDoListy" value="/ciuch/przeniesDoListy">
                    <c:param name="ciuchId" value="${singleCiuch.ciuchid}"/>
                </c:url>
                <%--                <c:url var="deleteLink" value="/ciuch/deleteCiuch">
                                    <c:param name="ciuchId" value="${singleCiuch.ciuchid}"/>
                                </c:url>--%>

                <tr>
                    <td>${singleCiuch.nazwa}</td>
                    <td>${singleCiuch.index}</td>
                    <td>${singleCiuch.status.nazwa}</td>
                    <td>${singleCiuch.wymiaryPaczki}</td>
                    <td><a href="${dodajDoListy}">Dodaj</a></td>
                        <%--                    <td><a href="${deleteLink}"--%>
                        <%--                           onclick="if(!(confirm('Are you sure to delete this ciuch?'))) return false"--%>
                        <%--                    >Delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
        <%--        <input type="button" value="Zatwierdz dostawe"
                       onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button"/>--%>
        <%--        <div id="wrapper">--%>
        <div id="subheader">
            <h3>Do wyslania na magazyn</h3>
        </div>
        <%--        </div>--%>
        <form:form action="saveStoredarticle" modelAttribute="storedarticle" method="POST">
            <table>
                <tr>
                    <th>Nazwa</th>
                    <th>Index</th>
                    <th>Status</th>
                    <th>Wymiary paczki</th>
                    <th>Usun z zamówienia</th>
                        <%--                <th>Remove</th>--%>
                </tr>
                <c:forEach var="singleCiuch" items="${ciuchyNaMagazyn}">
                    <c:url var="updateLink" value="/ciuch/usunZListy">
                        <c:param name="ciuchId" value="${singleCiuch.ciuchid}"/>
                    </c:url>
                    <%--                <c:url var="deleteLink" value="/ciuch/deleteCiuch">
                                        <c:param name="ciuchId" value="${singleCiuch.ciuchid}"/>
                                    </c:url>--%>

                    <tr>
                        <td>${singleCiuch.nazwa}</td>
                        <td>${singleCiuch.index}</td>
                        <td>${singleCiuch.status.nazwa}</td>
                        <td>${singleCiuch.wymiaryPaczki}</td>
                        <td><a href="${updateLink}">Usun</a></td>
                            <%--                    <td><a href="${deleteLink}"--%>
                            <%--                           onclick="if(!(confirm('Are you sure to delete this ciuch?'))) return false"--%>
                            <%--                    >Delete</a></td>--%>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Zatwierdz dostawe"
                   class="add-button"/>
        </form:form>
    </div>
</div>
</body>

</html>









