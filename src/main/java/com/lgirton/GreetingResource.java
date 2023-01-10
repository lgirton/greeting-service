package com.lgirton;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello from RESTEasy Reactive");
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Greeting> greeting(@PathParam("name") String name) {
        return Uni.createFrom().item(greet(name));
    }

    private static Greeting greet(String name) {
        return Greeting.builder().message(String.format("Hello %s", name)).build();
    }
}
