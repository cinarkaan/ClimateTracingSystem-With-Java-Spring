<%--
  Created by IntelliJ IDEA.
  User: kaan
  Date: 24.03.2020
  Time: 14:36
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="${pageContext.request.contextPath}/resources/Style/css/results.css?v=0.00477" type="text/css" rel="stylesheet" >
    <title>LongResult</title>
</head>
<body>

<div class="Container">

    <h1>${ForecastLong.services.toUpperCase()} SERVİSİNDEN ALINAN VERİLER</h1> <br><br>

    Country : ${ForecastLong.country} <br><br>
    Province : ${ForecastLong.province} <br><br>
    Day : ${ForecastLong.day} <br><br>
    Month : ${ForecastLong.service.month} <br><br>
    HighTemperature : ${ForecastLong.service.highTemperature} <br><br>
    LowTemperature : ${ForecastLong.service.lowTemperature} <br><br>
    EventDay : ${ForecastLong.service.eventDay} <br><br>
    EventNight : ${ForecastLong.service.eventNight} <br><br>



</div>

</body>
</html>
