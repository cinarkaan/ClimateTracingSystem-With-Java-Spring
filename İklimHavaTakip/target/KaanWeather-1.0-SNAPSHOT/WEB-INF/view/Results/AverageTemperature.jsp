<%@ page import="com.weather.forecast.Model.DB.TemplateMethod.AverageTemperature" %>
<%@ page import="com.weather.forecast.Model.DB.Entity.TemperatureAverage" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 15.05.2020
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AverageTemperature</title>
</head>
<body style="background-color:#191919; color: white">
    <table border="1" width="1000" align="center">
        <h1 align="center">SON 39 YILIN SICAKLIK ORTALAMALARI</h1>
        <tr bgcolor="00FF7F">
            <th><b>Year</b></th>
            <th><b>Temperature</b></th>
        </tr>
        <%
            AverageTemperature averageTemperature = new AverageTemperature();
            ArrayList<TemperatureAverage> averageArrayList = averageTemperature.getTemperatureByYearList();
            for (TemperatureAverage data: averageArrayList) { %>
        <tr>
            <td><%=data.getYear()%></td>
            <td><%=data.getAverageTemperature()%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
