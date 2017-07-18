<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 14:20
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
    <title>Table_Order_Page</title>
</head>
<body>
<c:if test="${message!=null}">
    <h4 style="color: green;">${message}</h4>
</c:if>
<table border="1">
    <tr>
        <th>ORDER STATUS</th>
        <th>ADD PRODUCT</th>
        <th>CLOSE ORDER</th>
        <th>CANCEL ORDER</th>
        <th>ORDER DETAILS</th>
    </tr>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.orderStatus}</td>
            <td><a href="/productInOrder/openProductInOrder/${order.table.tableId}/${order.orderId}">Add Product</a>
            </td>
            <td><a href="/order/closeOrder/${order.orderId}">Close Order</a></td>
            <td><a href="/order/cancelOrder/${order.orderId}">Cancel Order</a></td>
            <td><a href="/order/orderDetails/${order.orderId}">Order Details</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/waiter/waiterPage">go to waiter page</a>
</body>
</html>
