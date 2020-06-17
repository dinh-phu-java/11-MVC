<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 6/17/2020
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Products</title>
</head>
<a href="${pageContext.request.contextPath}/home">Back to Home</a>
<body>
        <form method="POST" action="/products">
            <label >Product Name</label>
            <input type="text" name="productName">
            <br>
            <label >Product Price</label>
            <input type="text" name="productPrice">
            <br>
            <button>Create</button>
        </form>
</body>
</html>
