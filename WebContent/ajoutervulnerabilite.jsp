<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une vulnerabilite</title>
</head>
	<body>

	<h3>Nouveau vulnerabilite</h3>
		<form action="displayvulnerabilites.jsp" method="GET">
			<fieldset>
				<table style="border:1px solid pink; width:800px">
					<tr>
						<td>
							<label>ID</label>
						</td>
						<td>
							<input name="id_v" type="text" size="5">
						</td>
					</tr>
					<tr>
						<td>
							<label>Synthese</label>
						</td>
						<td>
							<input name="synthese_vulnerabilite" type="text" size="80">
						</td>
					</tr>
					<tr>
						<td>
							<label>Description</label>
						</td>
						<td>
							<input name="description_vulnerabilite" type="text" size="80">
						</td>
					</tr>
					<tr>
						<td>
							<label>Niveau gravite (sur 4)</label>
						</td>
						<td>
							<input name="niv_gravite" type="text" size="5">
						</td>
					</tr>
					<tr>
						<td>
							<label>Source (url)</label>
						</td>
						<td>
							<input name="url_source" type="text" size="80">
						</td>
					</tr>
					<tr>
						<td>
							<label>Date de creation</label>
						</td>
						<td>
							<input type="date" id="date_creation" name="date_creation" placeholder="yyyy-mm-dd" value="" min="1990-01-01" >
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
	
	<script>
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	 if(dd<10){
	        dd='0'+dd
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 

	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("date_creation").setAttribute("max", today);
</script>

	</body>
</html>