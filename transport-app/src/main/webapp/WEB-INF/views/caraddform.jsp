
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form:form method="POST"
               action="/car/add" modelAttribute="carDTO">
        <table>

            <tr>
                <td><label>Plate</label></td>
                <td><form:input path="plate"/>
                    <c:if test="${error.hasFieldErrors('plate')}">
                        <c:out value="${error.getFieldError('plate').defaultMessage}"/>
                    </c:if></td></td>

            </tr>
            <tr>
                <td><label>Brand</label></td>
                <td><form:input path="brand"/>
                <c:if test="${error.hasFieldErrors('brand')}">
                    <c:out value="${error.getFieldError('brand').defaultMessage}"/>
                </c:if></td>
            </tr>
            <tr>
                <td><label>model</label></td>
                <td><form:input path="model"/>
                    <c:if test="${error.hasFieldErrors('model')}">
                        <c:out value="${error.getFieldError('model').defaultMessage}"/>
                    </c:if></td>
            </tr>
            <tr>
                <td><label>mileage</label></td>
                <td><form:input path="mileage"/><c:if test="${error.hasFieldErrors('mileage')}">
                    <c:out value="${error.getFieldError('mileage').defaultMessage}"/>
                </c:if></td>
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
</body>
</html>
