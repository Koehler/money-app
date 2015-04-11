package de.koehler.money.bondary;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.koehler.money.entity.Account;

@Path("/accounts")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AccountsResource {

	@GET
	@Path("/{param}")
	public Response getAccount(@PathParam("param") String msg) {
		String output = "#GET: Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@GET
	public Response getAllAccounts() {
		String output = "#GET: Jersey say : all accounts";
		return Response.status(200).entity(output).build();
	}
	
	@POST	
	public Response create(@PathParam("param") String msg) {
		String output = "#POST: Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@PUT	
	public Response update(@PathParam("param") String msg) {
		String output = "#POST: Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@DELETE
	public Response delete(){
		String output = "#POST: Jersey say : deleted resource";
		return Response.status(200).entity(output).build();
	}

}
