package mano.jpa.controllers;

import lombok.Getter;
import lombok.Setter;
import mano.jpa.entities.Virejas;
import mano.jpa.dao.VirejasDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by arturas on 2017-03-20.
 * PSK 1 laboratorinis
 */

//todo išsiaškinti šitą
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
        virejasDAO.create(virejas);
    }

    public List<Virejas> getAllVirejas()
    {
        return virejasDAO.getAllVirejas();
    }

}
