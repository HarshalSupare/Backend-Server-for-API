package com.restAPI.Services;

import com.restAPI.controllers.InternsApiController;
import com.restAPI.wrapper.InternData;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/interns")
public class InternsApi {
    @GET
    public Response getInterns(){
        return Response.status(Response.Status.OK).entity(InternsApiController.getIntersData()).type("application/json;charset=utf-8").build();
    }

    @POST
    @Path("/create")
    public Response postInternsData(InternData recieveData){
        return Response.status(Response.Status.OK).entity(InternsApiController.postInternsData(recieveData)).type("application/json;charset=utf-8").build();
    }

    @GET
    @Path("/{id}")
    public Response getSingleInter(@PathParam("id") Integer recieveId){
        return Response.status(Response.Status.OK).entity(InternsApiController.findIntern(recieveId)).type("application/json;charset=utf-8").build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateLead(@PathParam("id") Integer id, InternData dataCollected){
        return Response.status(Response.Status.OK).entity(InternsApiController.updateInternsData(id, dataCollected)).type("application/json;charset=utf-8").build();

    }
}
