<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 84888
  Date: 11/17/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Dang nhap</h1>
<c:if test="${message != null}">
    <h2>${message}</h2>
</c:if>
<form method="post">
    <tr>
        <th>Username</th>
        <td><input type="text" name="username" placeholder="input username"></td>
    </tr>
    <tr>
        <th>Password</th>
        <td><input type="password" name="password" placeholder="input password"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="submit"></td>
    </tr>
</form>
</body>
</html>
