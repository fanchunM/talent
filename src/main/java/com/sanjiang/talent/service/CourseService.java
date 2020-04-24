package com.sanjiang.talent.service;

import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.CourseUnits;
import com.sanjiang.talent.vo.CommonComboDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CourseService {
    /**
     * 获取课程列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getCourseManage(Integer page, Integer rows);
    /**
     * 新增课程
     * @param moudle
     */
    void createCourse(Course moudle);

    /**
     * 删除课程
     * @param ids
     */
    void deleteCourse(List<String> ids);

    /**
     * 获取开课单位列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getCourseUnitsManage(Integer page, Integer rows);

    /**
     * 新增开课单位
     * @param courseUnits
     */
    void createCourseUnits(CourseUnits courseUnits);

    /**
     * 删除开课单位
     * @param ids
     */
    void deleteCourseUnits(List<String> ids);

    /**
     * 获取课程combobox
     * @param q
     * @return
     */
    List<Course> getCourse(String q);

    /**
     * 获取开课单位combo
     * @param q
     * @return
     */
    List<CommonComboDto> getCourseUnitsForCombo(String q);
}
