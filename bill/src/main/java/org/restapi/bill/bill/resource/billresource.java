package org.restapi.bill.bill.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.bill.bill.model.billmodel;
import org.restapi.bill.bill.service.billservice;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class billresource {
	
	billservice service = new billservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public billmodel addUser(billmodel user) {
		 return service.insertUser(user);		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<billmodel>  getUser() throws SQLException {
		 return service.getUser();
		
	}
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<billmodel>  getUser(@PathParam("id") int id) throws SQLException {
		return service.getUserById(id);
		
	}
	
	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public billmodel updateUser(billmodel user) {
		 return service.updatetUser(user);
		
	}
	
	@Path("/deleteById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		return service.deletetUser(id);
		
	}


}
