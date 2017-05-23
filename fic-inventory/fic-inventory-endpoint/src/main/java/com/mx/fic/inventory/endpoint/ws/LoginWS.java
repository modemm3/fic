package com.mx.fic.inventory.endpoint.ws;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/login")
public class LoginWS {
	
	@POST
	@Path("authenticate")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response aunthenticate(@FormParam("userName") final String userName,@FormParam("password") final String password){
		return Response.status(Status.OK).entity("Acceso Permitido").build();
	}

}
