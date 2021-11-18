<%--
  Created by IntelliJ IDEA.
  User: Thai Vu
  Date: 17-Nov-21
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<head>
    <title>Ministry</title>
</head>
<style>
    div {
        margin-left: 400px;
        width: 700px;
    }
</style>
<body>
<center>
    <h1 style="color: #dc3545; text-decoration: none">Ministry Manager</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5" class="table table-info table-hover table-striped">
        <tr>
            <td colspan="7" style="text-align: center"><h4>Ministry</h4></td>
        </tr>
        <tr>
            <th>ID</th>
            <th>Name Ministry</th>
            <th>Email</th>
            <th>Date of birth</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Action</th>

        </tr>
        <c:forEach items='${requestScope["ministry"]}' var="m">
            <tr>
                <td><c:out value="${m.getId()}"/></td>
                <td><c:out value="${m.getName()}"/></td>
                <td><c:out value="${m.getEmail()}"/></td>
                <td><c:out value="${m.getDob()}"/></td>
                <td><c:out value="${m.getAddress()}"/></td>
                <td><c:out value="${m.getPhone()}"/></td>
                <td>
                    <a href="/ministries?action=edit&id=${m.getId()}">Edit</a>
                    <a href="/ministries?action=delete&id=${m.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</html>
