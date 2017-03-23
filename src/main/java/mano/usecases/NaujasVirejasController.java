package mano.usecases;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mano.jpa.entities.Virejas;
import mano.jpa.dao.VirejasDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by arturas on 2017-03-20.
 */


//todo kas čia?
@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class NaujasVirejasController {

    @Getter
    private Virejas virejas = new Virejas();

    @Inject
    private VirejasDAO virejasDAO;

    public void createVirejas()
    {
        virejas.setNr(452);
        virejas.setVardas("Petras");
        virejas.setPavarde("Antanaitis");
        virejasDAO.create(virejas);
    }

    public List<Virejas> getAllVirejas(){return virejasDAO.getAllVirejas();}

}
