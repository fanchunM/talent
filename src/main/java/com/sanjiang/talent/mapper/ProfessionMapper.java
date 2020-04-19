package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.profession.Profession;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    @Select("select * from profession where id = #{id}")
    Profession getProfessionById(@Param("id") String id);

    List<Profession> getProfessionManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows);

    @Select("select count(*) from profession")
    Integer getProfessionCount();

    void createProfession(Profession course);

    @Update("update profession set name = #{profession.name}, code_in = #{profession.codeIn}, code_out = #{profession.codeOut} where id = #{profession.id}")
    int updateProfession(@Param("profession") Profession profession);

    int deleteProfession(@Param("idList") List<String> idList);

    @Select("select * from profession where name like '%${q}%'")
    List<Profession> getProfession(@Param("q") String q);
}
