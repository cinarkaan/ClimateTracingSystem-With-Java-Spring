<%--
  Created by IntelliJ IDEA.
  User: kaan-
  Date: 1.05.2020
  Time: 13:04
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Analysis</title>
    <link href="${pageContext.request.contextPath}/resources/Style/css/results.css?v=0.00477" type="text/css" rel="stylesheet" />
</head>
<body>

    <div class="Container">

        <h2>HER İKİ SERVİSTEKİ VERİLERİN ANALİZİ (SICAKLIK ORTALAMALARI VE HADİSE KARŞILAŞTIRMALI)</h2> <br><br>

        Country : ${Search.country} <br><br>
        Province : ${Search.province} <br><br>
        Average Temperature : ${Search.service.temperature} <br><br>
        Average Reel Feel : ${Search.service.reelFeel} <br><br>
        EventACCUWEATHER : ${Search.event1} <br><br>
        EventWUNDERGROUND : ${Search.event2} <br><br>
        Humidity :${Search.service.humitiy} <br><br>
        Pressure : ${Search.service.pressure} <br><br>
        Windy : ${Search.service.windys} <br><br>

    </div>

</body>
</html>
