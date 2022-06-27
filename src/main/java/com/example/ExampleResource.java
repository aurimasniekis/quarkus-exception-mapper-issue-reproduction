package com.example;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MyEntity hello(@PathParam("id") String id) {
        var obj = MyEntity.findById(Long.valueOf(id));

        return (MyEntity) obj;
    }
}
