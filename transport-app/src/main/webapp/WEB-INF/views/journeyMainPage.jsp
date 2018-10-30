<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<head>
    <meta charset="UTF-8">
    <title>mainPage</title>
</head>
<body>
<div align="left"><h4><a href="/journeyorder/add">add journey</a> </h4></div>
<div align="center">

    <table border="1" cellpadding="5">
        <tr>
            <th>plate</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Mileage</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="journeyOrder" items="${journeyList}">

            <c:url var="deleteUrl" value="delete">
                <c:param name="id" value="${journeyOrder.id}"/>
            </c:url>
            <tr>
                <td><c:out value="${journeyOrder.date}"/></td>
                <td><c:out value="${journeyOrder.destination}"/></td>
                <td><c:out value="${journeyOrder.driver.lastName}"/></td>
                <td><c:out value="${journeyOrder.car.plate}"/></td>
                <td><form  method="GET" action="/journeyOrder/delete">
                    <input type="hidden" name="id" value="${journeyOrder.id}">
                    <input type='submit' name='cancel' value='Delete'>
                    </form></td>
            </tr>

        </c:forEach>

    </table>

</div>
</body>
</html>