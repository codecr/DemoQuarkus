package dev.gerardo;

import dev.gerardo.service.HelloClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {


    @Inject
    HelloService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return service.getSaludo("Gerardo");
    }

    @GET
    @Path("/saludos/{nombre}")
    public String saludos(@PathParam(value = "nombre") String nombre) {
        return service.getSaludo(nombre);
    }

}
