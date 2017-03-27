package mano.jpa.controllers;

import lombok.Getter;
import lombok.Setter;
import mano.jpa.dao.PatiekalasDAO;
import mano.jpa.entities.Patiekalas;
import org.omnifaces.util.Messages;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;

/**
 * PSK 1 laboratorinis
 * Created by arturas on 2017-03-27.
 */
@Model
public class PatiekalasControllerJPA
{
    @Getter @Setter
    private Patiekalas patiekalas = new Patiekalas();

    @Inject
    private PatiekalasDAO patiekalasDAO;

    public List<Patiekalas> getAllPatiekalas()
    {
        return patiekalasDAO.getAllPatiekalas();
    }

    @Transactional
    public void createPatiekalas()
    {
        try
        {
            patiekalasDAO.create(patiekalas);
        }
        catch (Exception e)
        {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
        }

    }

}

