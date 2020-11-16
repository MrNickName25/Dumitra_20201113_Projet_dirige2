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
<title>Liste des users (visualisation)</title>
</head>
<body>
<jsp:useBean id="usr" class="users.User"/>
<jsp:useBean id="modu" class="users.ModelUser"/>
	
	<jsp:setProperty property="*" name="usr"/>
	<c:if test="${usr!=null and usr.nom!=null and usr.id_u>0}">
			${modu.ajouterUser(usr)}
	</c:if>
	
<h3>Liste des users</h3>
	<table style="border:1px solid blue; width:700px">
		<tr>
			<td><b>ID</b></td>
			<td><b>Nom</b></td>
			<td><b>Role</b></td>
			<td><b>Details</b></td>
			<td><b>Suppression</b></td>
		</tr>
		<c:forEach var="u" items="${modu.versCollection()}">
			<tr>
				<td>${u.id_u}</td>
				<td>${u.nom}</td>
				<td>${u.role}</td>				
					<c:url value="/detailsuser.jsp" var="affiche">
						<c:param name="id_u" value="${u.id_u}"/>
					</c:url>
				<td><a href="${affiche}">Afficher...</a></td>
				
					<c:url value="/SupprimerUser" var="url_supp">
						<c:param name="id_u" value="${u.id_u}"></c:param>							
					</c:url>								
				<td><a href="${url_supp}">Supprimer...</a></td>
			</tr>
			</c:forEach>
	</table>		
	<table style="border:1px solid red; width:300px">	
		<tr>
			<td ><a href="ajouteruser.jsp">Ajouter un utilisateur</a></td>
		</tr>
		<tr>
			<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
		</tr>	<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
</body>
</html>