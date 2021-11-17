<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 84888
  Date: 11/17/2021
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Teacher</title>
</head>
<body>
    <c:if test="${teacher != null}">
        <h1>Wellcome ${teacher.getName()}</h1>
    </c:if>
</body>
</html>
