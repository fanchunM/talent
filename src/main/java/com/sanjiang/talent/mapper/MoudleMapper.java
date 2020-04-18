package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.course.Moudle;
import com.sanjiang.talent.po.course.Platform;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoudleMapper {

    @Select("select * from moudle where id = #{id}")
    Moudle getMoudleById(@Param("id") String id);

    List<Moudle> getMoudleManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows);

    @Select("select count(*) from moudle")
    Integer getMoudleCount();

    void createMoudle(Moudle moudle);

    @Update("update moudle set name = #{moudle.name}, platform_id = #{moudle.platformId} where id = #{moudle.id}")
    int updateMoudle(@Param("moudle") Moudle moudle);

    int deleteMoudle(@Param("idList") List<String> idList);

    @Select("select * from moudle where name like '%${q}%'")
    List<Moudle> getMoudle(@Param("q") String q);

    @Select("select * from moudle where platform_id= #{platformId}")
    List<Moudle> getMoudleByPlatform(@Param("platformId") String platformId);
}
