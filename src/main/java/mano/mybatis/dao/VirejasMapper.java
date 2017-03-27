package mano.mybatis.dao;

import java.util.List;
import mano.mybatis.model.Virejas;
import org.mybatis.cdi.Mapper;

@Mapper
public interface VirejasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virejas
     *
     * @mbg.generated Sat Mar 25 19:58:01 EET 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virejas
     *
     * @mbg.generated Sat Mar 25 19:58:01 EET 2017
     */
    int insert(Virejas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virejas
     *
     * @mbg.generated Sat Mar 25 19:58:01 EET 2017
     */
    Virejas selectByNr(int nr);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virejas
     *
     * @mbg.generated Sat Mar 25 19:58:01 EET 2017
     */
    List<Virejas> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table virejas
     *
     * @mbg.generated Sat Mar 25 19:58:01 EET 2017
     */
    int updateByPrimaryKey(Virejas record);
}