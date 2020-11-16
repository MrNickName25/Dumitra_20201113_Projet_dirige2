<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="connexion.Connecteur"%>
<%@ page import="users.User"%>
<%@ page import="users.ModelUser"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details participant</title>
</head>
<body>
	<jsp:useBean id="modu" class="users.ModelUser"/>
	<c:set var="usr" value="${modu.chercherUser(param.id_u)}"/>
	
	<h3>Details user</h3>
				<table style="border:1px solid yellow; width:400px">
					<tr>
						<td>Code</td>
						<td>${usr.id_u}</td>
					</tr>
					<tr>
						<td>NOM</td>
						<td>${usr.nom}</td>
					</tr>
					<tr>
						<td>Login</td>
						<td>${usr.username}</td>
					</tr>
					<tr>
						<td>Mot de passe</td>
						<td>${usr.password}</td>
					</tr>
  				</table>
		<table style="border:1px solid red; width:300px">	
			<tr>
				<td ><a href="displayusers.jsp">Go back...</a></td>
			</tr>
			<tr>
				<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
			</tr>	<tr>
				<td ><a href="Deconnexion">Se deconnecter ...</a></td>
			</tr>
		</table>
	</body>
</html>