package com.restAPI.Services.filters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;

import java.io.IOException;

public class Response implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext res) throws IOException {
        System.out.println("Response filter run");


        MultivaluedMap<String, Object> hdr = res.getHeaders();
        // Standard CORS Headers
        hdr.add( "Access-Control-Allow-Origin", "*" );
        hdr.add( "Access-Control-Allow-Headers", "origin, content-type, accept, authorization" );
        hdr.add( "Access-Control-Allow-Credentials", "true" );
        hdr.add( "Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD" );
    }
}
