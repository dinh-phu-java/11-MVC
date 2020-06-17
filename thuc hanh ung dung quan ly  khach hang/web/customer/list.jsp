<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 6/17/2020
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <p>
        <a href="customers?action=create">Create new Customer</a>
    </p>

    <table border="1">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${requestScope.customers}" var="customer">
            <tr>
                <td><a href="customers?action=view&id=${customer.getId()}">${customer.getId()}</a> </td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td><a href="customers?action=edit&id=${customer.getId()}">Edit</a></td>
                <td><a href="customers?action=delete&id=${customer.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
