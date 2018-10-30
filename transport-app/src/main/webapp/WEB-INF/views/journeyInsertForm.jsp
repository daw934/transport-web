
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<div align="center"--%>
<div align="center"><jsp:include page="journeyMainPage.jsp"></jsp:include>
<div align="left">
    <td><c:out value="${journeyOrder.car.plate}"/></td>
    <form:form method="POST"
               action="/journeyorder/add" modelAttribute="journeyOrderDto">
        <table>
            <tr>
                <td><label>Destination</label></td>
                <td><form:input path="destination"/>
                    <c:if test="${error.hasFieldErrors('destination')}">
                        <c:out value="${error.getFieldError('destination').defaultMessage}"/>
                    </c:if></td>
            </tr>
            <tr>
                <td><label>Date(np.2002-12-30)</label></td>
                <td><form:input path="date"/><c:if test="${error.hasFieldErrors('date')}">
                    <c:out value="${error.getFieldError('date').defaultMessage}"/>
                </c:if></td>
            </tr>

            <tr>
                <td><label>Driver Last Name</label></td>
                <td><form:input path="driverLastName"/>
                    <c:if test="${error.hasFieldErrors('driverLastName')}">
                        <c:out value="${error.getFieldError('driverLastName').defaultMessage}"/>
                    </c:if></td>
            </tr>
            <tr>
                <td><label>Plate</label></td>
                <td><form:input path="carPlate"/>
                    <c:if test="${error.hasFieldErrors('carPlate')}">
                        <c:out value="${error.getFieldError('carPlate').defaultMessage}"/>
                    </c:if></td></td>

            </tr>

            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>

        </table>
        <br

        <%--<c:if test="${not empty error }">--%>
            <%--<c:out value="${error}"--%>
            <%--<c:forEach var="err" items="${error}">--%>
                    <%--<c:out value="${err.defaultMessage}"/>--%>
                <%--<br>--%>
            <%--</c:forEach>--%>
        <%--</c:if>--%>
        </form:form>
</div>
    <div>
        <label><c:out value="${currency.code}" /></label>
        <label><c:out value="${currency.rates.get(0).mid}" /></label>

    </div>

</div>
</body>
</html>
