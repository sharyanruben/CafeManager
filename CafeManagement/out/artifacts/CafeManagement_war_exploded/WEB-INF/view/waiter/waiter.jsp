<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 13:10
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
    <title>Waiter Page</title>
</head>
<body>
<h3>WELCOME ${waiter.username}</h3>
<c:if test="${message!=null}">
    <h4 style="color: green;">${message}</h4>
</c:if>

<table border="1">
    <tr>
        <th>Table Name</th>
        <th>Table Status</th>
        <th>Create Order</th>
        <th>Show Orders</th>
    </tr>
    <c:forEach items="${tableList}" var="table">
        <tr>
            <td>${table.tableName}</td>

            <c:if test="${table.tableStatus == 0}">
                <td>ORDERED</td>
            </c:if>
            <c:if test="${table.tableStatus == 1}">
                <td>FREE</td>
            </c:if>
            <td><a href="/order/createOrders/${table.tableId}">create orders</a></td>
            <td><a href="/order/showOrders/${table.tableId}">show orders</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/logOut">LOG_OUT</a>

</body>
</html>
