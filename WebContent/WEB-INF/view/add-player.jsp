<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addPlayerStylesheet.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1>Add Player</h1>
	<f:form modelAttribute="playerData" action="addNewPlayer">
		Name: <f:input path="playerName" />
		<f:errors path="playerName" cssClass="error" />
		<br>
		Number: <f:input path="playerNumber" />
		<f:errors path="playerNumber" cssClass="error" />
		<br>
		Choose a Player Position :
		<f:select path="playerPosition">
			<f:option value="Goalkeeper" />
			<f:option value="Forward" />
			<f:option value="Attacking midfielder" />
		</f:select>
		<br>
		<input type="submit" value="Add the player">
	</f:form>

</body>
</html>