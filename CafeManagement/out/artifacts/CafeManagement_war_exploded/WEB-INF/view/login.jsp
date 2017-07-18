<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Login Page</title>
</head>
<body>
<h4>Login Page</h4>
<h4 style="color:red">${message}</h4>
<form:form commandName="user" action="/login" method="post">
    <form:errors path="username" cssStyle="color:red"/><br>
    <form:input path="username" placeholder="username"/>
    <form:errors path="password" cssStyle="color:red"/><br>
    <form:password path="password" placeholder="password"/><br>
    <input type="submit" value="login">
</form:form>
</body>
</html>
