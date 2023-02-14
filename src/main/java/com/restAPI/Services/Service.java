package com.restAPI.Services;

import com.restAPI.controllers.StudentController;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/student")
public class Service {

    public static String responseType = "text/plain;charset=utf-8";
    @GET
    public Response getStudentName(){
        return Response.status(Response.Status.OK).entity("this is get request hit").type(responseType).build();
    }

    @POST
    @Path("/createRecord")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveData(StudentData dataCollected) {
        return Response.status(Response.Status.OK).entity(StudentController.addStudent(dataCollected)).type(responseType).build();
    }




    @GET
    @Path("/viewStudent/{id}")
    public Response viewUser(@PathParam ( "id" ) Integer studentId){
        return Response.status(Response.Status.OK).entity(StudentController.getStudent(studentId).toString()).type("text/plain;charset=utf-8").build();
    }



}
