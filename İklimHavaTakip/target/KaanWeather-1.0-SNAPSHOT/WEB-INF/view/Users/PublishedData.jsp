<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 8.05.2020
  Time: 14:09
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/Style/css/userprofile.css?v=0.002" type="text/css" rel="stylesheet"/>
    <title>PublishedData</title>
</head>
<body>
<div>
    <form:form cssClass="enterProfileInform" modelAttribute="publishData" action="PublishUserData">
        <h1>Publish</h1><br><br>
        <form:input type="text" placeholder="Location" path="userPublished.location"/><br><br>
        <form:input type="text" placeholder="Temperature" path="userPublished.currently_temperature"/><br><br>
        <form:input type="text" placeholder="Event" path="userPublished.currently_event"/><br><br>
        <form:input type="text" placeholder="Humidity" path="userPublished.currently_humidity"/><br><br>
        <form:input type="text" placeholder="Windy" path="userPublished.getCurrently_windy"/><br><br>
        <input type="submit" name="submit" value="Publish" />
    </form:form>
</div>
</body>
</html>
