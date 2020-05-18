<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link
			href="${pageContext.request.contextPath}/resources/Style/css/search.css?v=0.00502"
			type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>ForecastCurrent</title>
</head>
<body>
<div class="Search">
	<h1>Search</h1>
	<form:form action="forecastResult" modelAttribute="Search">
		Location : <form:input path="province" cssClass="province"/>
		<br />
		<br />
		Country : <form:select path="country" cssClass="country">
		<form:option value="NONE" label="Select"/>
		<form:options items="${countryList}"/>
	</form:select>
		<br>
		<br>
		Services : <form:select path="services" cssClass="country">
		<form:option value="NONE" label="Select"/>
		<form:options items="${services}"/>
	</form:select>
		<br>
		<br>
		<input type="submit" name="submit" class="submit"/>
	</form:form>
	<div></div>
</div>
</body>
</html>