package suniukai.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import suniukai.model.Darbuotojas;

@Mapper
public interface DarbuotojasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table darbuotojas
     *
     * @mbg.generated Thu Mar 30 12:28:53 EEST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table darbuotojas
     *
     * @mbg.generated Thu Mar 30 12:28:53 EEST 2017
     */
    int insert(Darbuotojas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table darbuotojas
     *
     * @mbg.generated Thu Mar 30 12:28:53 EEST 2017
     */
    Darbuotojas selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table darbuotojas
     *
     * @mbg.generated Thu Mar 30 12:28:53 EEST 2017
     */
    List<Darbuotojas> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table darbuotojas
     *
     * @mbg.generated Thu Mar 30 12:28:53 EEST 2017
     */
    int updateByPrimaryKey(Darbuotojas record);
}