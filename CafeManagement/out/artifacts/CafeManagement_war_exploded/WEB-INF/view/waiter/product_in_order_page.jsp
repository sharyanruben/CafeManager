<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 15:10
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
    <title>Add Product Page</title>
</head>
<body>
<c:if test="${message!=null}">
    <h4 style="color: green;">${message}</h4>
</c:if>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>
                <form action="/productInOrder/addProduct" method="post">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <input type="hidden" name="orderId" value="${order.orderId}">
                    <input type="number" name="amount" placeholder="amount" required>
                    <input type="submit" value="add product into order">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/waiter/waiterPage">go to waiter page</a>
</body>
</html>
