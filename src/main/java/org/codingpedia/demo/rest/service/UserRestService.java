package org.codingpedia.demo.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codingpedia.demo.rest.dao.UserDao;
import org.codingpedia.demo.rest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Service class that handles REST requests
 * @author amacoder
 *
 */
@Component
@Path("/podcasts")
public class UserRestService {
	
	@Autowired
	private UserDao UserDao;
	
	/************************************ CREATE ************************************/
	
	/**
	 * Adds a new resource (user) from the given json format (at least title and feed elements are required
	 * at the DB level)
	 * 
	 * @param user
	 * @return
	 */
	@POST 
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	@Transactional
	public Response createUser(User user) {
		UserDao.createUser(user);
		
		return Response.status(201).entity("A new user/resource has been created").build();
	}	
	
	/**
	 * Adds a new resource (user) from "form" (at least title and feed elements are required
	 * at the DB level)
	 *
	 * @param email
	 * @param first_name
	 * @param last_name
	 * @param detail_address
	 * @param city
	 * @param state
	 * @param user_name
	 * @param password
	 * @param salt
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.TEXT_HTML})
	@Transactional
	public Response createUserFromForm(
			@FormParam("email") String email,
			@FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("detail_address") String detail_address,
			@FormParam("city") String city,
			@FormParam("state") String state,
			@FormParam("user_name") String user_name,
			@FormParam("password") String password,
			@FormParam("salt") String salt
	) {
		User user = new User(email, first_name, last_name,  detail_address,  city,
				 state, user_name, password, salt);
		UserDao.createUser(user);

		return Response.status(201).entity("A new user/resource has been created").build();
	}

	/**
	 * A list of resources (here users) provided in json format will be added
	 * to the database.
	 * 
	 * @param users
	 * @return
	 */
	@POST @Path("list")
	@Consumes({MediaType.APPLICATION_JSON})
	@Transactional
	public Response createUsers(List<User> users) {
		for(User user : users){
			UserDao.createUser(user);
		}
		
		return Response.status(204).build(); 	
	}
	
	/************************************ READ ************************************/
	/**
	 * Returns all resources (users) from the database
	 * @return
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<User> getUser() {
		return UserDao.getUsers();
	}
		
	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response findById(@PathParam("id") Long id) {		
		User userById = UserDao.getUserById(id);
		if(userById != null) {
			return Response.status(200).entity(userById).build();
		} else {
			return Response.status(404).entity("The podcast with the id " + id + " does not exist").build();
		}
	}

	
	/************************************ UPDATE ************************************/
	/**
	 * Updates the attributes of the podcast received via JSON for the given @param id
	 * 
	 * If the podcast does not exist yet in the database (verified by <strong>id</strong>) then
	 * the application will try to create a new podcast resource in the db
	 * 
	 * @param user_id
	 * @param user
	 * @return
	 */	
	@PUT @Path("{user_id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})	
	@Transactional
	public Response updateUserById(@PathParam("user_id") Long user_id, User user) {
		if(user.getUser_id() == null) user.setUser_id(user_id);
		String message; 
		int status; 
		if(userWasUpdated(user)){
			status = 200; //OK
			message = "User has been updated";
		} else if(userCanBeCreated(user)){
			UserDao.createUser(user);
			status = 201; //Created 
			message = "The user you provided has been added to the database";
		} else {
			status = 406; //Not acceptable
			message = "The information you provided is not sufficient to perform either an UPDATE or "
					+ " an INSERTION of the new user resource <br/>"
					+ " If you want to UPDATE please make sure you provide an existent <strong>id</strong> <br/>"
					+ " If you want to insert a new user please provide at least a <strong>title</strong> and the <strong>feed</strong> for the user resource";
		}
		
		return Response.status(status).entity(message).build();		
	}

	private boolean userWasUpdated(User user) {
		return UserDao.updateUser(user) == 1;
	}

	private boolean userCanBeCreated(User user) {
		return user.getPassword() != null && user.getEmail()!=null;
	}	
	
	/************************************ DELETE ************************************/
	@DELETE @Path("{id}")
	@Produces({MediaType.TEXT_HTML})
	@Transactional
	public Response deletePodcastById(@PathParam("id") Long id) {
		if(UserDao.deleteUserById(id) == 1){
			return Response.status(204).build();
		} else {
			return Response.status(404).entity("User with the id " + id + " is not present in the database").build();
		}
	}
	
	@DELETE
	@Produces({MediaType.TEXT_HTML})
	@Transactional
	public Response deletePodcasts() {
		UserDao.deleteUsers();
		return Response.status(200).entity("All podcasts have been successfully removed").build();
	}	
	
	public void setUserDao(UserDao userDao) {
		this.UserDao = userDao;
	}	
	
	
}
