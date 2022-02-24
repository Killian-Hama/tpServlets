<div>
	<form method="POST">
		<div class="mb-3">
			<label for="dateInput" class="form-label">date:</label> <input type="date" class="form-control"
				id="dateInput" name="dateInput" aria-describedby="dateHelp">
			<div id="dateHelp" class="form-text">Veuillez entrer la date du repas</div>
		</div>
		<div class="mb-3">
			<label for="heureInput" class="form-label">heure:</label> <input type="time" class="form-control"
				id="heureInput" name="heureInput" aria-describedby="heureHelp">
			<div id="heureHelp" class="form-text">Veuillez entrer l'heure du repas</div>
		</div>
		<div class="mb-3">
			<label for="repasInput" class="form-label">Repas: </label>
			<textarea class="form-control"
				id="repasInput" name="repasInput" rows="5" cols="50"></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>