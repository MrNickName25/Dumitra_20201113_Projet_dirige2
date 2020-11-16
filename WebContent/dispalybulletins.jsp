<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="connexion.Connecteur"%>
<%@ page import="vulnerabilities.Menace"%>
<%@ page import="vulnerabilities.ModelMenace"%>
<%@ page import="vulnerabilities.ModelLogiciel"%>
<%@ page import="vulnerabilities.ModelSolution"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des bulletins (visualisation)</title>
</head>
<body>
	<jsp:useBean id="men" class="vulnerabilities.Menace" />
	<jsp:useBean id="modelmen" class="vulnerabilities.ModelMenace" />
	<jsp:useBean id="modell" class="vulnerabilities.ModelLogiciel" />
	<jsp:useBean id="models" class="vulnerabilities.ModelSolution" />

	<h3>Liste des vulnerabilites</h3>
	<table style="border: 1px solid blue; width: 1200px">
		<tr style="font-size: 12px">
			<td style="width: 30px"><b>ID</b></td>
			<td><b>Synthese</b></td>
			<td><b>Description</b></td>
			<td><b>Gravite</b> (sur 4)</td>
			<td><b>Source (url)</b></td>
			<td><b>Date de creation</b></td>
			<td style="width: 500px">
				<table style="border: 1px solid green; width: 500px, font-size: 10px">
					<tr>
						<td colspan="3" style="width: 200px"><b>Logiciels affectés</b><td>
					</tr>
					<tr>
						<td style="width: 30px">ID</td>	
						<td style="width: 120px">Software impacte</td>	
						<td style="width: 50px">version</td>
						<td style="width: 300px"><b>Liste des solutions</b><br>
							<table style="border: 1px solid orange; width: 200px, font-size: 8px">
								<tr>
									<td style="width: 30px">ID</td>	
									<td style="width: 270px">Description</td>
									<td><b>...to PDF</b></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>	
		</tr>
		<c:forEach var="v" items="${modelmen.afficherCollection(sessionScope.userID)}">
			<tr style="font-size: 10px">
				<td style="text-align: center, width: 30px">${v.id_v}</td>
				<td>${v.synthese_vulnerabilite}</td>
				<td>${v.description_vulnerabilite}</td>
				<td style="text-align: center">${v.niv_gravite}</td>
				<td>${v.url_source}</td>
				<td style="font-size: 8px">${v.date_creation}</td>
				<td style="width: 500px">
					<table style="border: 1px solid green; width: 500px, font-size: 10px">
						<c:forEach var="lc" items="${modell.afficherCollection(sessionScope.userID,v.id_v)}">
						
						
							<tr>
								<td style="width: 30px">${lc.id_l}</td>
								<td style="width: 120px">${lc.nom_logiciel}</td>
								<td style="width: 50px">${lc.version_logiciel}</td>
								<td style="width: 300px">
									<table style="border: 1px solid orange; width: 300px, font-size: 8px">
										<c:forEach var="sl"	items="${models.versCollection(lc.id_l,v.id_v )}">
											<tr>
												<td style="width: 30px">${sl.id_s}</td>
												<td style="width: 270px">${sl.description_solution}</td>
												<td>
					<c:url value="/BulletinPDF" var="show">
						<c:param name="id_index_vulnerabilite" value="${v.id_v}"/>
						<c:param name="id_index_logiciel" value="${lc.id_l}"/>
					</c:url>
				<a href="${show}">*.pdf</a></td>
											</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				
			</tr>
		</c:forEach>
	</table>

	<table style="border: 1px solid red; width: 300px">
		<tr>
			<td><a href="4users.jsp">Retour a la liste des actions</a></td>
		</tr>
		<tr>
			<td><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
</body>
</html>