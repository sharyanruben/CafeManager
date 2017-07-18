<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 14:25
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
    <title>Show Order Details Page</title>
</head>
<body>
<h3>Show Order Details Page</h3>
<c:if test="${message!=null}">
    <h4 style="color: green;">${message}</h4>
</c:if>
<table border="1">
    <tr>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Amount</th>
    </tr>
    <c:forEach items="${productInOrderList}" var="orderProduct">
        <tr>
            <td>${orderProduct.product.productName}</td>
            <td>${orderProduct.product.price}</td>
            <td>${orderProduct.orderAmount}</td>
        </tr>
    </c:forEach>
</table>
<a href="/waiter/waiterPage">go to waiter page</a>
</body>
</html>
