<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<head>
    <meta charset="UTF-8">
    <title>mainPage</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Pesel</th>
            <th>Delete</th>
            </tr>

        <c:forEach var="driver" items="${drivers}">

            <c:url var="deleteUrl" value="delete">
                <c:param name="id" value="${driver.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${driver.firstName}"/></td>
                <td><c:out value="${driver.lastName}"/></td>
                <td><c:out value="${driver.pesel}"/></td>
                <td><form  method="GET" action="/driver/delete">
                <input type="hidden" name="id" value="${driver.id}">
                <input type='submit' name='cancel' value='Delete'>
            </form></td>
            </tr>

        </c:forEach>

    </table>

</div>
<div align="left">
    <a href="/driver/add">Add Driver</a>
</div>
</body>
</html>