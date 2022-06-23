package com.example;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class JacksonErrorMapper {
    @ServerExceptionMapper
    public Response handleError(JsonMappingException e) {

        return Response.status(400).entity("JacksonErrorMapper").build();
    }
}
