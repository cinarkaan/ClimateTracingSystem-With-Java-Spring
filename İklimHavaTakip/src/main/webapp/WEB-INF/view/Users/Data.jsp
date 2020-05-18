<%@ page import="java.util.ArrayList" %>
<%@ page import="com.weather.forecast.Model.DB.Entity.UserData" %>
<%@ page import="com.weather.forecast.Model.DB.TemplateMethod.GetUserData" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 8.05.2020
  Time: 19:39
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data</title>
</head>
<body style="background-color:#191919; color: white" >

<table border="1" width="1000" align="center">
    <h1 align="center">KULLANCILARIN GİRMİŞ OLDUĞU VERİLER</h1>
    <tr bgcolor="00FF7F">
        <th><b>Name</b></th>
        <th><b>Surname</b></th>
        <th><b>Location</b></th>
        <th><b>Date</b></th>
        <th><b>Time</b></th>
        <th><b>Temperature</b></th>
        <th><b>Event</b></th>
        <th><b>Humidity</b></th>
        <th><b>Windy</b></th>
    </tr>
        <%
            GetUserData getUserData = new GetUserData();
            ArrayList<UserData> userData = getUserData.getList();
            for (UserData data: userData) {%>
               <tr>
                   <td><%=data.getName()%></td>
                   <td><%=data.getSurname()%></td>
                   <td><%=data.getLocation()%></td>
                   <td><%=data.getPublish_Date()%></td>
                   <td><%=data.getPublish_Time()%></td>
                   <td><%=data.getTemperature()%></td>
                   <td><%=data.getEvent()%></td>
                   <td><%=data.getHumidity()%></td>
                   <td><%=data.getWindy()%></td>
               </tr>
            <%}%>
</table>
</body>
</html>
