package com.restAPI.Services;

import com.restAPI.controllers.LeadApiController;
import com.restAPI.wrapper.LeadData;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/lead")
public class LeadApi {
    @GET
    public Response getLeads(){
        return Response.status(Response.Status.OK).entity(LeadApiController.getLeadData()).type("application/json;charset=utf-8").build();
    }

    @GET
    @Path("/find/{id}")
    public Response findLead(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(LeadApiController.findLeadData(id)).type("application/json;charset=utf-8").build();
    }

    @POST
    @Path("/create")
    public Response createLead(LeadData dataCollected){

        return Response.status(Response.Status.OK).entity(LeadApiController.addLeadData(dataCollected)).type("text/plain;charset=utf-8").build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLead(@PathParam("id") Integer id){
        return Response.status(Response.Status.OK).entity(LeadApiController.deleteLeadData(id)).type("text/plain;charset=utf-8").build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateLead(@PathParam("id") Integer id, LeadData dataCollected){
        return Response.status(Response.Status.OK).entity(LeadApiController.updateLeadData(id, dataCollected)).type("text/plain;charset=utf-8").build();

    }
}
