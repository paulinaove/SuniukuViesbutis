package mano.jpa.dao;

import mano.jpa.entities.Uzsakymas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by arturas on 2017-03-23.
 */
@ApplicationScoped
public class UzsakymasDAO {

    @Inject
    private EntityManager entityManager;

    public void create(Uzsakymas uzsakymas)
    {
        entityManager.persist(uzsakymas);
    }

    public List<Uzsakymas> getAllUzsakymas()
    {
        return entityManager.createNamedQuery("Uzsakymas.findAll", Uzsakymas.class).getResultList();
    }
}
