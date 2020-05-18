<%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 8.05.2020
  Time: 12:11
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/Style/css/userprofile.css?v=0.003" type="text/css" rel="stylesheet"/>
    <title>UpdateProfile</title>
</head>
<body>
<div>
    <form:form cssClass="enterProfileInform" modelAttribute="updateInform" action="Update">
        <h1>UpdateProfile</h1> <br><br>
        <form:input type="text" placeholder="Name" path="userProperties.name"/><br><br>
        <form:input type="text" placeholder="Surname" path="userProperties.surname"/><br><br>
        <form:input type="text" placeholder="Phone" path="userProperties.phone"/><br><br>
        <form:input type="text" placeholder="Job" path="userProperties.job"/><br><br>
        <form:input type="text" placeholder="ReasonRegister" path="userProperties.reason_register"/><br><br>
        <form:input type="text" placeholder="Country" path="userProperties.country"/><br><br>
        <form:input type="text" placeholder="City" path="userProperties.city"/><br><br>
        <input type="submit" name="submit" value="Update" />
    </form:form>
</div>
</body>
</html>
