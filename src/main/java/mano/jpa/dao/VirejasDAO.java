package mano.jpa.dao;

import mano.jpa.entities.Virejas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by arturas on 2017-03-20.
 */

//todo kas čia yra
@ApplicationScoped
public class VirejasDAO {

    @Inject
    private EntityManager entityManager;

    public void create(Virejas virejas)
    {
        entityManager.persist(virejas);
    }

    public List<Virejas> getAllVirejas()
    {
        return entityManager.createNamedQuery("Virejas.findAll", Virejas.class).getResultList();
    }

}
