package suniukai;

import lombok.Getter;
import lombok.Setter;
import suniukai.dao.DarbuotojasMapper;
import suniukai.model.Darbuotojas;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * PSK 1 laboratorinis
 * Created by arturas on 2017-03-30.
 */
@Model
public class controller
{
    @Inject
    private DarbuotojasMapper  darbuotojasMapper;

    public List<Darbuotojas> getDarbuotojas(){return darbuotojasMapper.selectAll();}


}
