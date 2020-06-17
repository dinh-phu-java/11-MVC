<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 6/17/2020
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>Edit Product Id: ${editProduct.productCode}</h1>
        <form method="post" action="products">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="productCode" value="${editProduct.productCode}">
            <label >Product Name</label>
            <input type="text" name="productName" value="${editProduct.getProductName()}">
            <br>
            <label >Product Price</label>
            <input type="text" name="productPrice" value="${editProduct.getProductPrice()}">
            <br>
            <button>Edit</button>
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/home">Back to Home</a>
</body>
</html>
