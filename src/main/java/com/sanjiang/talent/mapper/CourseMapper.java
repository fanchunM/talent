package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.Moudle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CourseMapper {
    @Select("select * from course where id = #{id}")
    Course getCourseById(@Param("id") String id);

    List<Course> getCourseManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows);

    @Select("select count(*) from course")
    Integer getCourseCount();

    void createCourse(Course course);

    @Update("update course set name = #{course.name}, code = #{course.code}, course_units_id = #{course.courseUnitsId}, moudle_id = #{course.moudleId} where id = #{course.id}")
    int updateCourse(@Param("course") Course course);

    int deleteCourse(@Param("idList") List<String> idList);

    @Select("select * from course where moudle_id = #{moudleId}")
    List<Course> getCourseByMoudleId(@Param("moudleId") String moudleId);

    @Select("select * from course where name like '%${q}%'")
    List<Course> getCourse(@Param("q") String q);



}
