<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<head>
    <meta charset="UTF-8">
    <title>mainPage</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">>
        <tr>
            <th>plate</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Mileage</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="car" items="${cars}">

            <c:url var="deleteUrl" value="delete">
                <c:param name="id" value="${car.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${car.plate}"/></td>
                <td><c:out value="${car.carDetails.brand}"/></td>
                <td><c:out value="${car.carDetails.model}"/></td>
                <td><c:out value="${car.carDetails.mileage}"/></td>
                <td><form  method="GET" action="/car/delete">
                    <input type="hidden" name="id" value="${car.id}">
                    <input type='submit' name='cancel' value='Delete'>
                    </form></td>
            </tr>

        </c:forEach>

    </table>

</div>
</body>
</html>