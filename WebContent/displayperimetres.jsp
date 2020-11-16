<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="connexion.Connecteur"%>
<%@ page import="vulnerabilities.ModelLogiciel"%>
<%@ page import="perimetre.ModelPerimetre"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des perimetres (visualisation)</title>
</head>
<body>
	<jsp:useBean id="modell" class="vulnerabilities.ModelLogiciel" />
	<jsp:useBean id="modelp" class="perimetre.ModelPerimetre" />
	<jsp:useBean id="p" class="perimetre.Perimetre"/>
	
	<c:forEach items="${paramValues.table_id_l}" var="item">
  				${modelp.ajouterPerimetre(sessionScope.userID,item)}
	</c:forEach>
	
Vos perimetres sont:
		<ul>
  			<c:forEach var="p" items="${modelp.versCollection(sessionScope.userID)}">
    			<li>${modell.chercherLogiciel(p.id_index_logiciel).nom_logiciel}</li>			 			
   			</c:forEach>
		</ul>
	
	<table style="border:1px solid red; width:300px">	
		<tr>
			<td ><a href="ajouterperimetres.jsp">Agrandir le perimetre</a></td>
		</tr>
		<tr>
			<td ><a href="4users.jsp">Retour a la liste des actions</a></td>
		</tr>
		<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
</body>
</html>