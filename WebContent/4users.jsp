<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actions users</title>
</head>
<body>

<h2>Bonjour, ${sessionScope.username}!</h2>
<h3>Actions (user)</h3>
	<table style="border:1px solid blue; width:1200px">
		<tr>
			<td><b><a href="displayperimetres.jsp">Visualisation perimetres</a></b></td>				
			<td><b><a href="dispalybulletins.jsp">Consultation bulletins</a></b></td>
			<td><b><a href="recherche.jsp"><i>Recherche avancee (pas fait)</i></a></b></td>
		</tr>
	</table>
	
	<table style="border:1px solid red; width:300px">	
		<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
</body>
</html>