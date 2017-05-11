package jpa;

import interceptors.*;
import jpa.dao.DarbuotojasDAO;
import jpa.dao.SuniukasDAO;
import jpa.model.Darbuotojas;
import jpa.model.Suniukas;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Suniukas suniukas = new Suniukas();
    @Getter
    private Darbuotojas darbuotojas = new Darbuotojas();


    @Inject
    private SuniukasDAO suoDAO;
    @Inject
    private DarbuotojasDAO darbDAO;

    @Transactional
    @loggingInterceptor
    public void sukurkSuniukaDarbuotoja() {

        darbuotojas.getSuniukasList().add(suniukas);
        suniukas.getDarbuotojasList().add(darbuotojas);
        darbDAO.create(darbuotojas);
        suoDAO.create(suniukas);
        log.info("Maybe OK...");
    }

    public List<Suniukas> getAllSuniukas() { return suoDAO.getAllSuniukas();
    }
}
