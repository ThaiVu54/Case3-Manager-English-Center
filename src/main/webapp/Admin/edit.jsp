<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TrangAnh LapTop
  Date: 11/17/2021
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Admin</title>
</head>
<body>
<h1>
    EDIT ADMIN PROFILE ( MAKE SURE YOU WANT TO EDIT! )
</h1>
<form action="/admin?action=edit" method="post">
    <table>
        <c:forEach items="${Admin}" var="a">
            <tr>
                <td>
                    Are you sure you want to change admin name?New name here!
                </td>
                <td>
                    <input type="text" name="name" value="${a.getName()}">
                </td>
            </tr>
            <tr>
                <td>
                    Your new email
                </td>
                <td>
                    <input type="text" name="email" value="${a.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>
                    Date of Birth
                </td>
                <td>
                    <input type="text" name="dob" value="${a.getDob()}">
                </td>
            </tr>
            <tr>
                <td>
                    New Address
                </td>
                <td>
                    <input type="text" name="address" value="${a.getAddress()}">
                </td>
            </tr>
            <tr>
                <td>
                    Phone Number
                </td>
                <td>
                    <input type="text" name="phone" value="${a.getPhone()}">
                </td>
            </tr>
            <tr>
                <td>
                    UserName
                </td>
                <td>
                    <input type="text" name="username" value="${a.getUsername()}">
                </td>
            </tr>
            <tr>
                <td>
                    PassWord
                </td>
                <td>
                    <input type="text" name="password" value="${a.getPassword()}">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="save">
                </td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>${AdminEdit}</tr>
    </table>
</form>
</body>
</html>
