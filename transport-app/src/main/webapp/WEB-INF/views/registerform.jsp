
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
               action="/register" modelAttribute="user">
        <table>
            <tr>
                <td><label>first name</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>last name</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>email</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label>password</label></td>
                <td><form:password path="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register"/></td>
            </tr>
        </table>
        <br>
        <c:if test="${not empty error }">
            <c:forEach var="err" items="${error.allErrors}">
                <c:out value="${err.defaultMessage}"/>
                <br>
            </c:forEach>
        </c:if>

            </form:form>
</div>
</body>
</html>
