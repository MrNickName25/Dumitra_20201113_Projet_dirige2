<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="connexion.Connecteur"%>
<%@ page import="vulnerabilities.Menace"%>
<%@ page import="vulnerabilities.ModelMenace"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des vulnerabilites (visualisation)</title>
</head>
<body>
	<jsp:useBean id="men" class="vulnerabilities.Menace" />
	<jsp:useBean id="modelmen" class="vulnerabilities.ModelMenace" />
	<jsp:useBean id="modell" class="vulnerabilities.ModelLogiciel" />
	<jsp:useBean id="models" class="vulnerabilities.ModelSolution" />
		
	<jsp:setProperty property="*" name="men"/>
	<c:if test="${men!=null and men.synthese_vulnerabilite!=null and men.niv_gravite>0 and men.niv_gravite<5 and men.id_v>0}">
			${modelmen.ajouterMenace(men)}
	</c:if>

<h3>Liste des vulnerabilites</h3>
	<table style="border:1px solid blue; width:1200px">
		<tr>
			<td><b>ID</b></td>
			<td><b>Synthese</b></td>
			<td><b>Description</b></td>
			<td><b>Niveau gravite (x sur 4)</b></td>
			<td><b>Source (url)</b></td>
			<td><b>Date de creation</b></td>
			<td><b>Logiciels impactes</b></td>
			<td><b>Supprimer</b></td>
		</tr>
		
		<c:forEach var="v" items="${modelmen.versCollection()}">
			<tr>
				<td style="text-align:center">${v.id_v}</td>
				<td>${v.synthese_vulnerabilite}</td>
				<td>${v.description_vulnerabilite}</td>				
				<td style="text-align:center">${v.niv_gravite}</td>
				<td>${v.url_source}</td>				
				<td>${v.date_creation}</td>
			
				<c:url value="/displaylogiciels.jsp" var="affiche">
					<c:param name="id_index_vulnerabilite" value="${v.id_v}"/>
				</c:url>
				<td><a href="${affiche}">Afficher...</a></td>

				<c:url value="/SupprimerVulnerabilite" var="url_supp">
					<c:param name="id_index_vulnerabilite" value="${v.id_v}"></c:param>							
				</c:url>								
				<td><a href="${url_supp}">Supprimer...</a></td>			
			</tr>
			</c:forEach>
	</table>

	<table style="border:1px solid red; width:300px">	
		<tr>
			<td ><a href="ajoutervulnerabilite.jsp">Ajouter une vulnerabilite</a></td>
		</tr>
		<tr>
			<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
		</tr>
		<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
</body>
</html>