package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.course.Platform;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformMapper {
    @Select("select * from platform where id = #{id}")
    Platform getPlatformById(@Param("id") String id);

    List<Platform> getPlatformManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows);

    @Select("select count(*) from platform")
    Integer getPlatformCount();

    void createPlatform(Platform role);

    @Update("update platform set name = #{platform.name} where id = #{platform.id}")
    int updatePlatform(@Param("platform") Platform platform);

    int deletePlatform(@Param("idList") List<String> idList);

    @Select("select * from platform where name like '%${q}%'")
    List<Platform> getPlatform(@Param("q") String q);
}
