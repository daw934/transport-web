
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="left">
    <form:form method="POST"
               action="/driver/add" modelAttribute="driver">
        <table>
            <tr>
                <td><label>Last Name</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <c:if test="${error.hasFieldErrors('lastName')}">
            <tr>
                <td></td>
                <td><c:out value="${error.getFieldError('lastName').defaultMessage}"/></td>
            </tr>
                </c:if>
            <tr>
                <td><label>First Name</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <c:if test="${error.hasFieldErrors('firstName')}">
                <tr>
                    <td></td>
                    <td><c:out value="${error.getFieldError('firstName').defaultMessage}"/></td>
                </tr>
            </c:if>
            <tr>
                <td><label>Pesel</label></td>
                <td><form:input path="pesel"/></td>
            </tr>

            <c:if test="${error.hasFieldErrors('pesel')}">
                <tr>
                    <td></td>
                    <td><c:out value="${error.getFieldError('pesel').defaultMessage}"/></td>
                </tr>
            </c:if>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
        <br

    </form:form>
</div>
</body>
</html>
