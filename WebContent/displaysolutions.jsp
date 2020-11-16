<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="connexion.Connecteur"%>
<%@ page import="vulnerabilities.Solution"%>
<%@ page import="vulnerabilities.ModelSolution"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Solutions</title>
</head>
<body>
<jsp:useBean id="models" class="vulnerabilities.ModelSolution"/>
<jsp:useBean id="sl" class="vulnerabilities.Solution"/>
<jsp:setProperty property="*" name="sl"/>

<c:if test="${sl!=null and sl.id_s!=null and sl.description_solution!=null and sl.id_s>0}">
			${models.ajouterSolution(sl)}
	</c:if>

<h3>Liste des solutions</h3>
	<table style="border:1px solid blue; width:700px">
		<tr>
			<td><b>ID</b></td>
			<td><b>Description</b></td>
			<td><b>Suppression</b></td>
		</tr>
		
		<c:forEach var="sl" items="${models.versCollection(param.id_index_logiciel, param.id_index_vulnerabilite)}">
					<tr>
						<td>${sl.id_s}</td>
						<td>${sl.description_solution}</td>
						<c:url value="/SupprimerSolution" var="url_supp">
							<c:param name="codesup" value="${sl.id_s}"></c:param>							
						</c:url>
						<td><a href="${url_supp}">Supprimer...</a>	
					</tr>
					</c:forEach>
	</table>
			
	<table style="border:1px solid red; width:300px">	
		<tr>
			<c:url value="/ajoutersolution.jsp" var="ajoutersolution">
				<c:param name="id_index_logiciel" value="${param.id_index_logiciel}"/>
				<c:param name="id_index_vulnerabilite" value="${param.id_index_vulnerabilite}"/>
			</c:url>
			<td><a href="${ajoutersolution}">Ajouter une solution</a></td>		
		</tr>
		<tr>
			<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
		</tr>	<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
</body>
</html>