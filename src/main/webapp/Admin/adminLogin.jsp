<%--
  Created by IntelliJ IDEA.
  User: TrangAnh LapTop
  Date: 11/18/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
  <p style="font-size: 20px; color: #222; text-transform: capitalize; margin-top: 45px; margin-left: 35px;">
    Đăng nhập</p>
  <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
    <label for="exampleInputEmail1" class="form-label">Username</label>
    <input name="username" type="text" class="form-control" id="exampleInputEmail1"
           aria-describedby="emailHelp">
  </div>
  <p>
    <c:if test="${mess != null}">
      <span>${mess}</span>
    </c:if>
  </p>
  <div class="mb-5" style="margin-left: 35px; height: 41px; width: 335px;">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-primary"
          style="margin-left: 35px; height: 41px; width: 335px; background: #ff5722">Submit
  </button>
</form>










</body>
</html>



