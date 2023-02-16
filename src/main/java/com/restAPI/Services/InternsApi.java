package com.restAPI.Services;

import com.restAPI.controllers.InternsApiController;
import com.restAPI.controllers.LeadApiController;
import com.restAPI.wrapper.InternData;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
}
