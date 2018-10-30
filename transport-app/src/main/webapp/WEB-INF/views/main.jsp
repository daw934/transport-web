<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<head>
    <meta charset="UTF-8">
    <title>MainWindow</title>

    <style>
        ul {

            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333333;
        }

        li h2 a {
            display: block;
            color: white;
            text-align: center;
            padding: 15px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111111;
        }
        body{
            background-color: #333333
        }
    </style>
</head>
<body>
<div align="left">
    <ul>
        <li><h2><a href="/menu">Car Menu</a></h2></li>
        <li><h2><a href="/driver">Driver Menu</a></h2></li>
        <li><h2><a href="/journeyorder">Journey Menu</a></h2></li>
        <li><h2><a href="/register">Register</a></h2></li>
    </ul>
    <form action="/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" value="Logout">
    </form>

</div>
</body>
</html>