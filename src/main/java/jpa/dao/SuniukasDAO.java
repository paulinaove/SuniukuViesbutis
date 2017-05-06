package jpa.dao;





import jpa.model.Suniukas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by paulinaoveraite on 2017-03-18.
 */
@ApplicationScoped
public class SuniukasDAO {
    @Inject
    private EntityManager em;

    public void create(Suniukas suo) {
        em.persist(suo);
    }

    public List<Suniukas> getAllSuniukas() {
        return em.createNamedQuery("Suniukas.findAll", Suniukas.class).getResultList();
    }

    public void atnaujintiIrFlush(Suniukas suniukas){
        em.merge(suniukas);
        em.flush();
    }

    public Suniukas rastiPagalId(String gyvunoID){
        return em.find(Suniukas.class, gyvunoID);
    }
}
