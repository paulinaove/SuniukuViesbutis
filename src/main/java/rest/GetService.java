package rest;

import jpa.model.Suniukas;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/suniukas")
@Produces(MediaType.APPLICATION_JSON)
public class GetService {

    @Inject
    private EntityManager em;

    @GET
    @Path("/{gyvunoID}")
    public Suniukas find(@PathParam("gyvunoID") String gyvunoID) {
        return em.find(Suniukas.class, gyvunoID);
    }


}