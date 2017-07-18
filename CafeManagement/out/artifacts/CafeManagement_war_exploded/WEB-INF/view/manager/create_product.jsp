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
    <title>Create Product Page</title>
</head>
<body>
<h3>CREATE PRODUCT</h3>
<c:if test="${message != null}">
    <h3 style="color:darkgreen">${message}</h3>
</c:if>
<form:form commandName="products" method="post" action="/product/createProduct">
    <form:errors path="productName" cssStyle="color: red"/><br>
    <form:input path="productName" placeholder="product Name"/><br>
    <form:errors path="price" cssStyle="color: red"/><br>
    <span>product price</span><br>
    <form:input path="price" placeholder="price" type="number"/><br>
    <input type="submit" value="ADD PRODUCT">
</form:form>
<c:url value="/managerPage/managerForm" var="manager"/>
<a href="${manager}">back to manager page</a>
</body>
</html>
