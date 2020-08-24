package dev.gerardo;

import com.sun.istack.NotNull;
import dev.gerardo.model.Usuarios;
import dev.gerardo.service.UsuariosService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosResource {
    @Context
    UriInfo context;

    @Inject
    UsuariosService service;

    @GET
    public List<Usuarios> getAll() {
        return service.getAll();
    }

    @GET
    @Path("{id}")
    public Usuarios  getUsuario(@PathParam("id") Integer id) {
        return service.getbyId(id);
    }

    @POST
    public Response guardar(@Valid @NotNull Usuarios u) {
        Usuarios user = service.add(u);

        return Response.created(buildUri(user)).build();
    }

    private URI buildUri(Usuarios user) {
        return context.getBaseUriBuilder()
                .path(UsuariosResource.class)
                .path(UsuariosResource.class, "getUsuario")
                .build(user.id);
    }

}
