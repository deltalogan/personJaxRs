package personJaxRs.person.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import personJaxRs.person.dao.PersonDAOImplementation;
import personJaxRs.person.models.PersonModel;
import personJaxRs.person.utilities.BeanResponseCRUD;

@Path("/person")
public class PersonController {

	@POST
	@Path("/create")
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(PersonModel personModel) {

		return Response.ok(new GenericEntity<BeanResponseCRUD>(new PersonDAOImplementation().create(personModel)) {
		}).build();
	}

//	@GET
//	@Path("/read")
//	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_XML })
//	public Response read() {
//
//		return Response.ok(new GenericEntity<BeanResponseCRUD>(new PersonDAOImplementation().read()) {
//		}).build();
//	}

	@GET
	@Path("/read")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response read(@DefaultValue("") @QueryParam("id") String id) {

		return Response.ok(new GenericEntity<BeanResponseCRUD>(new PersonDAOImplementation().read(id)) {
		}).build();
	}

	@PUT
	@Path("/update/{id : \\d+}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response update(PersonModel personModel, @PathParam("id") long id) {

		return Response.ok(new GenericEntity<BeanResponseCRUD>(new PersonDAOImplementation().update(personModel, id)) {
		}).build();
	}

	@DELETE
	@Path("/delete/{id : \\d+}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response delete(@PathParam("id") long id) {

		return Response.ok(new GenericEntity<BeanResponseCRUD>(new PersonDAOImplementation().delete(id)) {
		}).build();
	}
}