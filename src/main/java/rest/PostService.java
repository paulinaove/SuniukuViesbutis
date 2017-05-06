package rest;

import jpa.model.Darbuotojas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by paulinaoveraite on 2017-05-06.
 */
@ApplicationScoped
@Path("/darbuotojas")
@Produces(MediaType.APPLICATION_JSON)
public class PostService {

    @Inject
    private EntityManager em;

    @Path("/atnaujinti/{id}")
    @POST
    @Transactional
    public Response update(@PathParam("id") String id,
                           @QueryParam("vardas") String vardas,
                           @QueryParam("pavarde") String pavarde,
                           @QueryParam("pareigos") String pareigos) {
        Darbuotojas darbuotojas = em.find(Darbuotojas.class, id);
        if (darbuotojas == null) {
            throw new IllegalArgumentException("darbuotojas id "
                    + id + " not found");
        }
        darbuotojas.setVardas(vardas);
        darbuotojas.setPavarde(pavarde);
        darbuotojas.setPareigos(pareigos);
        em.merge(darbuotojas);
        return
                Response.ok(darbuotojas).build(); // low level API
    }
}
