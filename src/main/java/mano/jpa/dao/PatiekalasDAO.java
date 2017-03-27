package mano.jpa.dao;

import mano.jpa.entities.Patiekalas;
import mano.jpa.entities.Uzsakymas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by arturas on 2017-03-23.
 */
@ApplicationScoped
public class PatiekalasDAO
{
    @Inject
    private EntityManager entityManager;

    public void create(Patiekalas patiekalas)
    {
        entityManager.persist(patiekalas);
    }

    public List<Patiekalas> getAllPatiekalas()
    {
        return entityManager.createNamedQuery("Patiekalas.findAll", Patiekalas.class).getResultList();
    }
}
