package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.course.CourseUnits;
import com.sanjiang.talent.po.course.Moudle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseUnitsMapper {
    @Select("select * from courseunits where id = #{id}")
    CourseUnits getCourseUnitsById(@Param("id") String id);

    List<CourseUnits> getCourseUnitsManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows);

    @Select("select count(*) from courseunits")
    Integer getCourseUnitsCount();

    void createCourseUnits(CourseUnits role);

    @Update("update courseunits set name = #{courseUnits.name} where id = #{courseUnits.id}")
    int updateCourseUnits(@Param("courseUnits") CourseUnits courseUnits);

    int deleteCourseUnits(@Param("idList") List<String> idList);

    @Select("select * from courseunits where name like '%${q}%'")
    List<CourseUnits> getCourseUnits(@Param("q") String q);

}
