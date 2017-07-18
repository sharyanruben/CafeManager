<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Create Waiter Page</title>
</head>
<body>
<h3>CREATE WAITER</h3>
<c:if test="${message != null}">
    <h4 style="color: darkgreen;">${message}</h4>
</c:if>
<form:form commandName="waiter" action="/waiter/addwaiter" method="post"><br>
    <form:errors path="username" cssStyle="color:red"/><br>
    <form:input path="username" placeholder="WaiterName"/><br>
    <form:errors path="password" cssStyle="color:red"/><br>
    <form:input path="password" placeholder="password"/><br>
    <input type="submit" value="ADD WAITER">
</form:form>
<c:url value="/managerPage/managerForm" var="manager"/>
<a href="${manager}">back to manager page</a>

</body>
</html>
