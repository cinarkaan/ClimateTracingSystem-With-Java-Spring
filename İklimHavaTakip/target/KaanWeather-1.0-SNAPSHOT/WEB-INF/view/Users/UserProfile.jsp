<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 18.04.2020
  Time: 16:35
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>

    <link href="${pageContext.request.contextPath}/resources/Style/css/userprofile.css?v=0.0012" type="text/css" rel="stylesheet"/>
</head>
<body>
<header>
    <div class="main">
        <div class="Logo">
            <img  src="${pageContext.request.contextPath}/resources/Style/img/mylogo.png">
        </div>
        <ul>
             <li class="active"><a href="${pageContext.request.contextPath}/">Logout</a></li>
             <li><a href="${pageContext.request.contextPath}/Login/DataPublish">PublishData</a></li>
            <li><a href="${pageContext.request.contextPath}/Login/UpdateProfile">Update</a></li>
            <li><a href="${pageContext.request.contextPath}/Login/Data">Data</a></li>
        </ul>
    </div>
</header>
<div class="profileInform">
    UserId : ${updateInform.userProperties.user_id==null ? Login.userProperties.user_id : updateInform.userProperties.user_id} <br><br>
    Name: ${updateInform.userProperties.name==null ? Login.userProperties.name : updateInform.userProperties.name} <br><br>
    Surname : ${updateInform.userProperties.surname==null ? Login.userProperties.surname : updateInform.userProperties.surname} <br><br>
    Phone : ${updateInform.userProperties.phone==null ? Login.userProperties.phone : updateInform.userProperties.phone} <br><br>
    Job : ${updateInform.userProperties.job==null ? Login.userProperties.job : updateInform.userProperties.job} <br><br>
    RegisterReason : ${updateInform.userProperties.reason_register==null ? Login.userProperties.reason_register : updateInform.userProperties.reason_register} <br><br>
    Country : ${updateInform.userProperties.country==null ? Login.userProperties.country : updateInform.userProperties.country} <br><br>
    City : ${updateInform.userProperties.city==null ? Login.userProperties.city : updateInform.userProperties.city} <br><br>
</div>
</body>
</html>
