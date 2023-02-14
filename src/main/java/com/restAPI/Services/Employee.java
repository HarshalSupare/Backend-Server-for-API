package com.restAPI.Services;



import com.restAPI.controllers.EmployeeController;
import com.restAPI.exception.InvalidIdException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/employee")
public class Employee {
    @GET
    public Response getStudentName(){
        return Response.status(Response.Status.OK).entity(EmployeeController.getEmployee()).type("application/json;charset=utf-8").build();
    }


    @POST
    @Path("/create")
    public Response createEmployee(EmployeeData dataCollected){

        return Response.status(Response.Status.OK).entity(EmployeeController.createRecord(dataCollected)).type("text/plain;charset=utf-8").build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteEmployee(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(EmployeeController.deleteRecord(id)).type( "application/json;charset=utf-8" ).build();
    }

    @PUT
    @Path("/update")
    public Response updateEmployee(EmployeeData updateData) throws InvalidIdException {
        return Response.status(Response.Status.OK).entity(EmployeeController.updateEmployee(updateData)).type("application/json;charset=utf-8").build();
    }
}
