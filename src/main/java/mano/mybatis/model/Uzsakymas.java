package mano.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Uzsakymas {

    private Long id;
    private Long nr;
    private Integer optlock;
    private Integer virejasNr;

    private Virejas virejasEntity;
    private List<Patiekalas> patiekalasList;


}