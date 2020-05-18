<%--
  Created by IntelliJ IDEA.
  User: kaan
  Date: 24.03.2020
  Time: 14:36
  To change this getUserData use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link href="${pageContext.request.contextPath}/resources/Style/css/results.css?v=0.00477" type="text/css" rel="stylesheet" />
<title>CurrentResult</title>
</head>
<body>

 <div class="Container">

	 <h1>${Search.services.toUpperCase()} SERVİSİNDEN ALINAN VERİLER</h1> <br><br>

	 Country : ${Search.country} <br><br>
	 Province : ${Search.province} <br><br>
	 Temperature : ${Search.service.temperature} <br><br>
	 Reel Feel : ${Search.service.reelFeel} <br><br>
	 Event : ${Search.service.event} <br><br>
	 Humidity :${Search.service.humitiy} <br><br>
	 Pressure : ${Search.service.pressure} <br><br>
	 Windy : ${Search.service.windys} <br><br>

 </div>


</body>
</html>