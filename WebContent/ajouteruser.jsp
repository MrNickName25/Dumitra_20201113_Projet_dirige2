<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un utilisateur</title>
</head>
	<body>

	<h3>Nouveau utilisateur</h3>
		<form action="displayusers.jsp" method="GET">
			<fieldset>
				<table style="border:1px solid pink; width:400px">
					<tr>
						<td>
							<label>ID</label>
						</td>
						<td>
							<input name="id_u" type="text">
						</td>
					</tr>
					<tr>
						<td>
							<label>Nom</label>
						</td>
						<td>
							<input name="nom" type="text">
						</td>
					</tr>
					<tr>
						<td>
							<label>Login</label>
						</td>
						<td>
							<input name="username" type="text">
						</td>
					</tr>
					<tr>
						<td>
							<label>Mot de passe</label>
						</td>
						<td>
							<input type="password" name="password">
						</td>
					</tr>
					<tr>
						<td>
							<label>Role</label>
						</td>
						<td>
							<input name="role" type="text">
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
  	<table style="border:1px solid red; width:200px">	
		<tr>
			<td ><a href="4admin.jsp">Retour a la liste des actions</a></td>
		</tr>	<tr>
			<td ><a href="Deconnexion">Se deconnecter ...</a></td>
		</tr>
	</table>
	</body>
</html>