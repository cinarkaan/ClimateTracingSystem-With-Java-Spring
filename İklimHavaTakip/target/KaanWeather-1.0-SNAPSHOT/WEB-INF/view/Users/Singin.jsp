<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 19.04.2020
  Time: 12:30
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/Style/css/formSing.css?v=0.002" type="text/css" rel="stylesheet"/>
    <title>Singİn</title>
</head>
<body>
<div>
    <form:form cssClass="login-box" modelAttribute="Login" action="UserLogin">
        <h1>Sing In</h1>
        <form:input name="text" type="text" placeholder="username" path="id"/> <br><br><br>
        <form:input type="password" name="password" placeholder="password" path="password"/> <br><br>
        <input type="submit" name="submit" value="Login" />
    </form:form>
</div>
</body>
</html>
