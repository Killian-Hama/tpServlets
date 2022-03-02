package fr.eni.tpServlets.api;

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
import fr.eni.tpServlets.bll.NotesManager;
import fr.eni.tpServlets.bo.Notes;

@Path("/notes")
public class GestionNotes {

	@GET
	public Response getNotes() {
		try {
			List<Notes> ln = NotesManager.getManager().listeNotes();
			return Response.status(Response.Status.OK).entity(ln).build();
		} catch (BLLException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@POST
	public Response ajouterNotes(@FormParam("content") String content) {
		try {
			Notes notes = new Notes(content);
			notes.setId(NotesManager.getManager().ajouterNotes(notes));
			return Response.status(Response.Status.CREATED).entity(notes).build();
		} catch (BLLException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Path("/{id:\\d+}")
	public Response modifierNotes(@PathParam("id") int id, @FormParam("content") String content) {
		try {
			Notes notes = new Notes(id, content);
			NotesManager.getManager().modifierNotes(notes);
			return Response.status(Response.Status.).entity(notes).build();
		} catch (BLLException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("/{id:\\d+}")
	public boolean supprimerNotes(@PathParam("id") int id)
	{
		try {
			NotesManager.getManager().supprimerNotes(id);
			return true;
		} catch (BLLException e) {
			return false;
		}
	}

}
