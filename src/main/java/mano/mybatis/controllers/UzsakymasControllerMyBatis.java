package mano.mybatis.controllers;

import mano.mybatis.dao.UzsakymasMapper;
import mano.mybatis.model.Uzsakymas;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * PSK 1 laboratorinis
 * Created by arturas on 2017-03-27.
 */
@Model
public class UzsakymasControllerMyBatis
{
    @Inject
    private UzsakymasMapper uzsakymasMapper;

    public List<Uzsakymas> getAllUzsakymas()
    {
        return uzsakymasMapper.selectAll();
    }
}
