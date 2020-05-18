<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/resources/Style/css/main.css?v=0.00493" type="text/css" rel="stylesheet" >
    <title>Weather</title>
</head>
<body>

<header>
    <h1 class="weather">KAAN WEATHER</h1>
    <div class="main">
             <div class="Logo">
                 <img  src="${pageContext.request.contextPath}/resources/Style/img/mylogo.png">
             </div>
              <ul>
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/Search/selectForecast">Forecast</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/Login/LoginUser">SingIn</a></li>
                <li><a href="${pageContext.request.contextPath}/Login/SingUpUser">SingUp</a></li>
                  <li><a href="${pageContext.request.contextPath}/Search/AverageTemp">AverageTemperature</a></li>
              </ul>
    </div>
</header>
</body>
</html>