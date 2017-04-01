package suniukai;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import suniukai.dao.DarbuotojasMapper;
import suniukai.dao.DarbuotojuSuniukuSarasasMapper;
import suniukai.dao.SuniukasMapper;
import suniukai.model.Darbuotojas;
import suniukai.model.DarbuotojuSuniukuSarasas;
import suniukai.model.Suniukas;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

    @Getter
    private Darbuotojas darbuotojas = new Darbuotojas();
    @Getter
    private Suniukas suniukas = new Suniukas();

    @Inject
    private DarbuotojasMapper darbuotojasMapper;
    @Inject
    private SuniukasMapper suniukasMapper;
    @Inject
    private DarbuotojuSuniukuSarasasMapper darbuotojuSuniukuSarasasMapper;

    public List<Darbuotojas> getAllDarbuotojas() {
        return darbuotojasMapper.selectAll();
    }

    @Transactional
    public void createDarbuotojasSuniukas() {
        darbuotojasMapper.insert(darbuotojas);
        suniukasMapper.insert(suniukas);
        DarbuotojuSuniukuSarasas darbuotojuSuniukuSarasas = new DarbuotojuSuniukuSarasas();
        darbuotojuSuniukuSarasas.setDarbuotojoid(darbuotojas.getId());
        darbuotojuSuniukuSarasas.setSuniukoid(suniukas.getGyvunoid());
        darbuotojuSuniukuSarasasMapper.insert(darbuotojuSuniukuSarasas);
        log.info("Maybe OK...");
    }
}
