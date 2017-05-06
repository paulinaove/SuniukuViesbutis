package rest;

import jpa.model.Suniukas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by paulinaoveraite on 2017-05-06.
 */
@ApplicationScoped
@Path("/naujassuniukas")
@Produces(MediaType.APPLICATION_JSON)
public class PutService {

    @Inject
    private EntityManager em;

    @PUT
    @Path("/save")
    @Transactional
    public Suniukas sukurtiSuniuka(@QueryParam("gyvunoID") String gyvunoID,
                                   @QueryParam("vardas") String vardas,
                                   @QueryParam("veisle") String veisle) {

        Suniukas suniukas = new Suniukas();
        suniukas.setGyvunoID(gyvunoID);
        suniukas.setVardas(vardas);
        suniukas.setVeisle(veisle);
        em.persist(suniukas);
        return suniukas;
    }
}
