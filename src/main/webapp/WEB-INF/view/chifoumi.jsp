
<%
Cookie[] cookies = request.getCookies();
if (cookies == null) {
%>




<%
} else {

%>
<div>
	<div class="mb-3">
		<label for="pseudo" class="form-label">Pseudo :</label> <input
			type="text" class="form-control" id="pseudo" name="pseudo"
			value="<%=cookies[cookies.length - 1]%>" disabled>
	</div>
	<a href="" class="btn btn-primary" role="button">Création d'une
		partie</a> <a href="#" class="btn btn-primary" role="button">Listes
		des parties</a>

</div>
<%
}
%>