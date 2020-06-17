<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 6/17/2020
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product List</h1>
<p>
<%--    <a href="http://localhost:8080/bai_tap_quan_ly_ung_dung_war_exploded/products?action=create">Add products</a>--%>
    <a href="${pageContext.request.contextPath}/products?action=create">Add Product</a>
</p>

<%--<c:if test="${products==null}"><p>Product is null</p></c:if>--%>
<table border="1">
    <tr>
        <th>Product Code</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach  items="${requestScope.products}" var="product">
        <tr>
            <td><a href="/products?action=view&amp;productCode=${product.productCode}">${product.getProductCode()}</a></td>
            <td>${product.getProductName()}</td>
            <td>${product.getProductPrice()}</td>
            <td><a href="/products?action=edit&amp;productCode=${product.productCode}">Edit</a></td>
            <td><a href="/products?action=delete&amp;productCode=${product.productCode}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
