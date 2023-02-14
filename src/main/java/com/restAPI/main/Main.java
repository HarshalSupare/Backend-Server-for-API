package com.restAPI.main;

import com.restAPI.factory.ApiFactory;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;


public class Main {
    private static final String URI_FORMAT = "%s://%s:%d";

    public static final URI BASE_URI =URI.create(String.format(URI_FORMAT, "http", "0.0.0.0", 5000));
    public static void main(String[] args) {
        try {
            System.out.println( String.format( "Starting Embedded HTTP Server; url=%s", BASE_URI ) );
            GrizzlyHttpServerFactory.createHttpServer( BASE_URI, new ApiFactory() );
            System.out.println( "Application started" );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}