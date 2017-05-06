package jpa.dao;

import jpa.model.Viesbutis;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by paulinaoveraite on 2017-05-06.
 */
@ApplicationScoped
public class ViesbutisDAO {
    @Inject
    private EntityManager em;

    public void create(Viesbutis viesbutis){
        em.persist(viesbutis);
    }

    public List<Viesbutis> getAllViesbutis(){
        return em.createNamedQuery("Viesbutis.findAll", Viesbutis.class).getResultList();
    }
}
