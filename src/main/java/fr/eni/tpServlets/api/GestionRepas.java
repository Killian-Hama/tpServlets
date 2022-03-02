package fr.eni.tpServlets.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import fr.eni.tpServlets.bll.BLLException;
import fr.eni.tpServlets.bll.RepasManager;
import fr.eni.tpServlets.bo.Repas;

@Path("/repas")
public class GestionRepas {

	@GET
	public Response getRepas() {
		try {
			List<Repas> ln = RepasManager.getManager().listeRepas();
			return Response.status(Response.Status.OK).entity(ln).build();
		} catch (BLLException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	public Response ajouterRepas(@FormParam("aliments") String aliments, @FormParam("datetime") LocalDateTime date) {
		try {
			Repas Repas = new Repas(date, aliments);
			Repas.setId(RepasManager.getManager().ajouterRepas(Repas));
			return Response.status(Response.Status.CREATED).entity(Repas).build();
		} catch (BLLException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{id:\\d+}")
	public boolean supprimerRepas(@PathParam("id") int id)
	{
		try {
			RepasManager.getManager().supprimerRepas(id);
			return true;
		} catch (BLLException e) {
			return false;
		}
	}

}
