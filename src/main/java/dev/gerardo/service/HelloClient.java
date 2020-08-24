package dev.gerardo.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
@RegisterRestClient
public interface HelloClient {
    @GET
    @Path("/saludos/{nombre}")
    public String saludos( String nombre);

}
