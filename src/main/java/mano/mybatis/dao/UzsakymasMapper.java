package mano.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Uzsakymas;

public interface UzsakymasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uzsakymas
     *
     * @mbg.generated Thu Mar 23 15:43:47 EET 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uzsakymas
     *
     * @mbg.generated Thu Mar 23 15:43:47 EET 2017
     */
    int insert(Uzsakymas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uzsakymas
     *
     * @mbg.generated Thu Mar 23 15:43:47 EET 2017
     */
    Uzsakymas selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uzsakymas
     *
     * @mbg.generated Thu Mar 23 15:43:47 EET 2017
     */
    List<Uzsakymas> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uzsakymas
     *
     * @mbg.generated Thu Mar 23 15:43:47 EET 2017
     */
    int updateByPrimaryKey(Uzsakymas record);
}