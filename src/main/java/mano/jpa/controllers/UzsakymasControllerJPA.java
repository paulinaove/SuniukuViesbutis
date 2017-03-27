package mano.jpa.controllers;

import lombok.Getter;
import lombok.Setter;
import mano.jpa.dao.UzsakymasDAO;
import mano.jpa.entities.Uzsakymas;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by arturas on 2017-03-27.
 * PSK 1 laboratorinis
 */
@Model
public class UzsakymasControllerJPA
{
    @Getter
    @Setter
    private Uzsakymas uzsakymas = new Uzsakymas();

    @Inject
    private UzsakymasDAO uzsakymasDAO;

    public List<Uzsakymas> getAllUzsakymas()
    {
        return uzsakymasDAO.getAllUzsakymas();
    }
}
