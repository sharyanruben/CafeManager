<%--
  Created by IntelliJ IDEA.
  User: RuBen
  Date: 27.03.2017
  Time: 12:31
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
    <title>Title</title>
</head>
<body>
<h3>hello ${manager.username} your manager page</h3>
<h3>ENTER ANY OPTION</h3>
<p><a href="/managerPage/createWaiterPage">CREATE WAITER</a></p>
<p><a href="/managerPage/createTablePage">CREATE TABLE</a></p>
<p><a href="/managerPage/createProductPage">CREATE PRODUCT</a></p>
<p><a href="/managerPage/assignTableToWaiterPage">ASSIGN TABLE TO WAITER</a></p>
<a href="/logOut">LOG_OUT</a>
</body>
</html>
