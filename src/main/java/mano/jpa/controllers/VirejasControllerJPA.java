package mano.jpa.controllers;

import lombok.Getter;
import lombok.Setter;
import mano.jpa.entities.Virejas;
import mano.jpa.dao.VirejasDAO;
import org.omnifaces.util.Messages;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by arturas on 2017-03-20.
 * PSK 1 laboratorinis
 */

@Model // tas pats kaip: @Named ir @RequestScoped
public class VirejasControllerJPA
{

    @Getter
    @Setter
    private Virejas virejas = new Virejas();

    @Inject
    private VirejasDAO virejasDAO;

    @Transactional
    public void createVirejas()
    {
        try
        {
            virejasDAO.create(virejas);
        }
        catch (Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
        }
    }

    public List<Virejas> getAllVirejas()
    {
        return virejasDAO.getAllVirejas();
    }

}
