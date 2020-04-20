package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.profession.ProfessionCourse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionCourseMapper {
    @Select("select * from professioncourse where id = #{id}")
    ProfessionCourse getProfessionCourseById(@Param("id") String id);

    List<ProfessionCourse> getProfessionCourseManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows, @Param("professionId") String professionId, @Param("courseId") String courseId);

    @Select("select count(*) from professioncourse")
    Integer getProfessionCourseCount();

    void createProfessionCourse(ProfessionCourse professionCourse);

    @Update("update professioncourse set profession_id = #{professionCourse.professionId}," +
            "course_id = #{professionCourse.courseId}," +
            "course_nature = #{professionCourse.courseNature}," +
            "course_in_credits = #{professionCourse.courseInCredits}," +
            "course_total_hours = #{professionCourse.courseTotalHours}," +
            "teaching = #{professionCourse.teaching}," +
            "onbroad = #{professionCourse.onbroad}," +
            "practice = #{professionCourse.practice}," +
            "laboratory = #{professionCourse.laboratory}," +
            "course_out_credits = #{professionCourse.courseOutCredits}," +
            "term1 = #{professionCourse.term1}," +
            "term2 = #{professionCourse.term2}," +
            "term3 = #{professionCourse.term3}," +
            "term4 = #{professionCourse.term4}," +
            "term5 = #{professionCourse.term5}," +
            "term6 = #{professionCourse.term6}," +
            "term7 = #{professionCourse.term7}," +
            "term8 = #{professionCourse.term8}" +
            " where id = #{professionCourse.id}")
    int updateProfessionCourse(@Param("professionCourse") ProfessionCourse professionCourse);

    int deleteProfessionCourse(@Param("idList") List<String> idList);
}
