
<%@ page import="java.util.List"%>
<%@ page import="fr.eni.tpServlets.bo.Repas"%>

<%
List<Repas> repas = (List<Repas>) request.getAttribute("repas");
%>

<h1 class="text-center color-primary">Historique</h1>

<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Repas repa : repas) {
			%>
			<tr>
				<th scope="row"><%=repa.getId()%></th>
				<td><%=repa.getDate()%></td>
				<td><%=repa.getDate().getHours() %>:<%= repa.getDate().getMinutes() %></td>
				<td>
					<button class="btn btn-primary" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapse"
						aria-expanded="false" aria-controls="collapseExample">+</button>
					<a class="btn btn-danger">X</a>
				</td>
			</tr>
			<tr class="collapse" id="collapse">
				<td colspan="4">
					<div class="d-flex">
						<%for (String aliment : repa.getAliments()) { %>
						<div class="ml-2">&bull;	<%=aliment%></div>
						<%}%>
					</div>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
</div>
