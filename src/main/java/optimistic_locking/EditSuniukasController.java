package optimistic_locking;


import jpa.dao.DarbuotojasDAO;
import jpa.dao.SuniukasDAO;
import jpa.dao.ViesbutisDAO;
import jpa.model.Darbuotojas;
import jpa.model.Suniukas;
import jpa.model.Viesbutis;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.omnifaces.cdi.ViewScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Hibernate;
import org.primefaces.context.RequestContext;

/**
 * Created by paulinaoveraite on 2017-05-06.
 */
@Named
@ViewScoped
@Slf4j
public class EditSuniukasController implements Serializable{

    @Getter private Suniukas pasirinktasSuniukas;
    @Getter private Suniukas konfliktinisSuniukas;
    @Getter private List<Suniukas> visiSuniukai;
    @Getter private List<Viesbutis> visiViesbuciai;
    @Getter private List<Darbuotojas> visiDarbuotojai;

    @Inject private SuniukasDAO suniukasDAO;
    @Inject private DarbuotojasDAO darbuotojasDAO;
    @Inject private ViesbutisDAO viesbutisDAO;

    @PostConstruct
    public void init(){
        perkrauti();}

    public void perkrauti(){
        visiSuniukai = suniukasDAO.getAllSuniukas();
        visiViesbuciai = viesbutisDAO.getAllViesbutis();
        visiDarbuotojai = darbuotojasDAO.getAllDarbuotojai();
    }

    public void paruostiPakeitimui(Suniukas suniukas){
        pasirinktasSuniukas = suniukas;
        konfliktinisSuniukas = null;
    }

    @Transactional
    public void atnaujintiPasirinktaSuniuka(){
        try{
            suniukasDAO.atnaujintiIrFlush(pasirinktasSuniukas);
            perkrauti();
        } catch (OptimisticLockException ole){
            konfliktinisSuniukas = suniukasDAO.rastiPagalId(pasirinktasSuniukas.getGyvunoID());
            Hibernate.initialize(konfliktinisSuniukas.getDarbuotojasList());
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void uzrasytiAntVirsaus(){
        pasirinktasSuniukas.setOptLockVersion(konfliktinisSuniukas.getOptLockVersion());
        atnaujintiPasirinktaSuniuka();
    }
}
