package com.restAPI.Services;

import com.restAPI.controllers.InternsApiController;
import com.restAPI.controllers.LeadApiController;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/interns")
public class InternsApi {
    @GET
    public Response getInterns(){
        return Response.status(Response.Status.OK).entity(InternsApiController.getIntersData()).type("application/json;charset=utf-8").build();
    }
}
