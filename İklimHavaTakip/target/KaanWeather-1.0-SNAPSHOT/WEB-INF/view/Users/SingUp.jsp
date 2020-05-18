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
    <link href="${pageContext.request.contextPath}/resources/Style/css/formSing.css?v=0.003" type="text/css" rel="stylesheet"/>
    <title>SingUp</title>
</head>
<body>
    <div>
        <form:form cssClass="Sing-Up-Box" modelAttribute="SingUp" action="UserRecord">
            <h1>SingUp</h1>
            <form:input name="text" type="text" path="id" placeholder="username"/><br><br><br>
            <form:input type="password" name="password" path="password" placeholder="password"/><br><br>
            <input type="submit" name="submit" value="SingUp" />
        </form:form>
    </div>
</body>
</html>
