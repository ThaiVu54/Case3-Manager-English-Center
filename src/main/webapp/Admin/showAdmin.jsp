<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TrangAnh LapTop
  Date: 11/17/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show admin</title>
</head>
<body>
<button>
    <a href="/admin?action=edit">Edit</a>
</button>
<h1>Admin in coming</h1>
<table border="1" bgcolor="#f5f5dc">
<tr>
    <th>Admin</th>
    <th>TOP SECRET INFORMATION</th>
</tr>
<c:forEach items="${Admin}" var="a">
<tr>
    <td>SuperDuper Master Name</td>
    <td>${a.getName()}</td>
</tr>
<tr>
    <td>Admin's Email</td>
    <td>${a.getEmail()}</td>
</tr>
<tr>
    <td>Date of Birth</td>
    <td>${a.getDob()}</td>
</tr>
<tr>
    <td>Admin's Address</td>
    <td>${a.getAddress()}</td>
</tr>
<tr>
    <td>Phone Number</td>
    <td>${a.getPhone()}</td>
</tr>
<tr>
    <td>Username</td>
    <td>${a.getUsername()}</td>
</tr>
<tr>
    <td>PassWord</td>
    <td>${a.getPassword()}</td>
</tr>
</c:forEach>
</table>
<table>
    <tr>${AdminEdit.name}</tr>
</table>
</body>
</html>
