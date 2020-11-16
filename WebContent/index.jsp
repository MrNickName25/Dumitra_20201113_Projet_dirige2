<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>-->


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'authentification</title>
</head>
<body>

	<h3>Authentification</h3>
		<form action="Authentification" method="GET">
			<fieldset>
				<table style="border:1px solid black; width:300px">
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
						<td colspan="2" style="text-align:center">
							<input type= "submit" value="Se connecter">
						</td>
					</tr>
  				</table>
   			</fieldset>
  		</form>

</body>
</html>