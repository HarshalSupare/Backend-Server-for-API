package com.restAPI.Services;

import com.restAPI.controllers.StudentJoinController;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/students")
public class StudentApi {
    static String jasonDataType = "application/json;charset=utf-8";
    @GET
    public static Response getAllStudent(){
        return Response.status(Response.Status.OK).entity(StudentJoinController.getAllStudents()).type(jasonDataType).build();
    }

    /**
     *
     * @return It returns the All Student based on join query.
     */
    @GET
    @Path("/scoreAndDetails")
    public static Response getQueryResult(){
        return Response.status(Response.Status.OK).entity(StudentJoinController.getJoinQueryResult()).type(jasonDataType).build();
    }
}


