package com.example;

import io.smallrye.mutiny.Uni;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MyEntity> hello(@PathParam("id") String id) {
        var obj = MyEntity.findById(Long.valueOf(id));
        return obj.onItem().ifNull().failWith(new WebApplicationException("Not found", 404))
                .onItem().transformToUni((myEntity, uniEmitter) -> {
                    var a = (MyEntity) myEntity;
                    if (a.field.equals("cool")) {
                        uniEmitter.complete(a);
                    } else {
                        uniEmitter.fail(new WebApplicationException("Invalid data", 401));
                    }
                });
    }
}
