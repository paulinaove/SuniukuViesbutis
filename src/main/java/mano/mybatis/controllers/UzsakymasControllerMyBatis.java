package mano.mybatis.controllers;

import lombok.Getter;
import lombok.Setter;
import mano.mybatis.dao.PatiekalasuzsakymasMapper;
import mano.mybatis.dao.UzsakymasMapper;
import mano.mybatis.dao.VirejasMapper;
import mano.mybatis.model.Patiekalasuzsakymas;
import mano.mybatis.model.Uzsakymas;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * PSK 1 laboratorinis
 * Created by arturas on 2017-03-27.
 */
@Model
public class UzsakymasControllerMyBatis
{

    @Getter
    @Setter
    private Uzsakymas uzsakymas = new Uzsakymas();

    @Getter
    @Setter
    private Patiekalasuzsakymas patiekalasuzsakymas = new Patiekalasuzsakymas();

    @Inject
    private UzsakymasMapper uzsakymasMapper;

    @Inject
    private PatiekalasuzsakymasMapper patiekalasuzsakymasMapper;

    public List<Uzsakymas> getAllUzsakymas()
    {
        return uzsakymasMapper.selectAll();
    }

    @Transactional
    public void createUzsakymas()
    {
        uzsakymas.setOptlock(0);
        try
        {
             uzsakymasMapper.insert(uzsakymas);
        }
        catch (Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
        }
    }

    @Transactional
    public void createPatiekalasUzsakymas()
    {
        try
        {
            patiekalasuzsakymasMapper.insert(patiekalasuzsakymas);
        }
        catch (Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));
        }
    }
}
