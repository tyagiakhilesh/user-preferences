package com.akhilesh.learning.resources;

import com.akhilesh.learning.core.UserService;
import com.akhilesh.learning.db.entity.UserEntity;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response getUser(@PathParam("userId") String userId) {
        return Response.ok(userService.getUser(userId)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @UnitOfWork
    public Response createUser(final UserEntity userEntity) {
        return Response.ok("Created " + userService.createUser(userEntity) + " successfully.").build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response getAllUsers() {
        return Response.ok(userService.getAllUsers()).build();
    }
}
