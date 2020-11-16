<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="connexion.Connecteur"%>
<%@ page import="vulnerabilities.ModelLogiciel"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details softwares</title>
</head>
<body>
	<jsp:useBean id="modell" class="vulnerabilities.ModelLogiciel"/>
	<jsp:useBean id="logi" class="vulnerabilities.Logiciel"/>
	<jsp:setProperty property="id_l" name="logi"/>
	<jsp:setProperty property="nom_logiciel" name="logi"/>
	<jsp:setProperty property="version_logiciel" name="logi"/>

	<jsp:useBean id="modelcor" class="vulnerabilities.ModelCorespondence"/>
	<jsp:useBean id="cor" class="vulnerabilities.Corespondence"/>
	<jsp:setProperty property="id_index_vulnerabilite" name="cor"/>
		
	<c:if test="${logi!=null and logi.nom_logiciel!=null and logi.version_logiciel!=null and logi.id_l>0}">
			${modell.ajouterLogiciel(logi)}
			${modelcor.ajouterCorespondence(cor.id_index_vulnerabilite, logi.id_l)}
	</c:if>
	
	<h3>Details software</h3>
				<table style="border:1px solid yellow; width:400px">
					<tr>
						<td>Software impacte</td>
						<td>version</td>
						<td><b>Solutions</b></td>
						<td>Suppression</td>
					</tr>
					<c:forEach var="lc" items="${modell.versCollection(param.id_index_vulnerabilite)}">
					<tr>
						<td>${lc.nom_logiciel}</td>
						<td>${lc.version_logiciel}</td>
						<c:url value="/displaysolutions.jsp" var="solutions">
							<c:param name="id_index_logiciel" value="${lc.id_l}"/>
							<c:param name="id_index_vulnerabilite" value="${param.id_index_vulnerabilite}"/>
						</c:url>
						<td><a href="${solutions}">Afficher...</a></td>
						<c:url value="/SupprimerLogiciel" var="url_supp">
							<c:param name="codel" value="${lc.id_l}"></c:param>							
						</c:url>
						<td><a href="${url_supp}">Supprimer...</a>	
					</tr>

					</c:forEach>
  				</table>
		<table style="border:1px solid red; width:300px">	
			<tr>
				<td ><a href="displayvulnerabilites.jsp">Go back...</a></td>
			</tr>
			<tr>
				<c:url value="/ajouterlogiciel.jsp" var="ajouterlogiciel">
							<c:param name="id_index_vulnerabilite" value="${param.id_index_vulnerabilite}"/>
						</c:url>
						<td><a href="${ajouterlogiciel}">Ajouter un logiciel</a></td>				
			</tr>
			<tr>
				<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
			</tr>	<tr>
				<td ><a href="Deconnexion">Se deconnecter ...</a></td>
			</tr>
		</table>
	</body>
</html>