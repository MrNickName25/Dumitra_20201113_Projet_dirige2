<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="perimetre.ModelPerimetre"%>
<%@ page import="perimetre.Perimetre"%>
<%@ page import="vulnerabilities.ModelLogiciel"%>
<%@ page import="vulnerabilities.Logiciel"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion perimetres</title>
</head>
<body>

<jsp:useBean id="modell" class="vulnerabilities.ModelLogiciel"/>
<jsp:useBean id="lc" class="vulnerabilities.Logiciel"/>

<h5>Merci de choisir votre perimetre de logiciles/vulnerabilite pour la visualisation</h5>
<form action="displayperimetres.jsp" method="GET">
			<fieldset>
				<table style="border:1px solid pink; width:400px">
					<tr>
						<td>
							<label>Logiciel</label>
						</td>
						<td>
							<select multiple size="5" id="table_id_l" name="table_id_l">
								<c:forEach var="lc" items="${modell.versCollection()}">
									<option value="${lc.id_l}">${lc.nom_logiciel}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center">
							<input type= "submit" value="Ajouter">
						</td>
					</tr>
  				</table>
   			</fieldset>
  		</form>
	
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