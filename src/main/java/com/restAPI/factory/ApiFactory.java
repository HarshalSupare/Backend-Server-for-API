package com.restAPI.factory;

import com.restAPI.Services.filters.Request;
import com.restAPI.Services.filters.Response;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/*")
public class ApiFactory extends ResourceConfig {

    public ApiFactory(){
        packages("com.restAPI.Services");
        register(Request.class);
        register(Response.class);
    }
}
