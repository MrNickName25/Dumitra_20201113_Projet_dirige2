<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un logiciel</title>
</head>
	<body>

<h3>Nouveau logiciel</h3>
	<form action="displaylogiciels.jsp" method="GET">
			<fieldset>
				<table style="border:1px solid pink; width:400px">
					<tr>
						<td><label>ID</label></td>
						<td><input name="id_l" type="text"></td>
					</tr>
					<tr>
						<td><label>Nom logiciel</label></td>
						<td><input name="nom_logiciel" type="text"></td>
					</tr>
					<tr>
						<td><label>Version</label></td>
						<td><input name="version_logiciel" type="text"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center">
							<input type= "submit" value="Ajouter">
						</td>
					</tr>
					<tr>
						<td><label>ID vulnerabilite</label></td>
						<td><input name="id_index_vulnerabilite" type="password" value="${param.id_index_vulnerabilite}" readonly></td>
					</tr>
  				</table>
   			</fieldset>
  		</form>
	
  		
  	<table style="border:1px solid red; width:200px">	
		<tr>
			<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
		</tr>	<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
	</body>
</html>