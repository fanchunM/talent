package com.sanjiang.talent.controller;

import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.CourseUnits;
import com.sanjiang.talent.service.CourseService;
import com.sanjiang.talent.vo.CommonComboDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/course/")
@SessionAttributes(value = {"loginUserDto"})
public class CourseController {
    @Autowired
    private CourseService courseService;


    @GetMapping("course_manage")
    public Map<String, Object> getCourseManage(@RequestParam(defaultValue = "1") String page,
                                               @RequestParam(defaultValue = "20") String rows) {

        return courseService.getCourseManage(Integer.valueOf(page), Integer.valueOf(rows));
    }

    @PostMapping("create_course")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("delete_course")
    public ResponseEntity<String> deleteCourse(@RequestBody List<String> ids) {
        log.info("delete course where id in {}", ids);
        courseService.deleteCourse(ids);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }


    @GetMapping("course_units")
    public Map<String, Object> getCourseUnitsManage(@RequestParam(defaultValue = "1") String page,
                                                 @RequestParam(defaultValue = "20") String rows) {

        return courseService.getCourseUnitsManage(Integer.valueOf(page), Integer.valueOf(rows));
    }

    @PostMapping("create_course_units")
    public ResponseEntity<String> createCourseUnits(@RequestBody CourseUnits courseUnits) {
        courseService.createCourseUnits(courseUnits);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("delete_course_units")
    public ResponseEntity<String> deleteCourseUnits(@RequestBody List<String> ids) {
        log.info("delete Course Units where id in {}", ids);
        courseService.deleteCourseUnits(ids);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @GetMapping("get_course")
    public List<CommonComboDto> getCourseCombobox(@RequestParam(defaultValue = "") String q) {
        List<Course> moudles = courseService.getCourse(q);
        List<CommonComboDto> commonComboDtos = new ArrayList<>();
        moudles.stream().forEach(o -> {
            CommonComboDto commonComboDto = new CommonComboDto();
            commonComboDto.setValue(o.getId());
            commonComboDto.setText(o.getCode() + "  " + o.getName());
            commonComboDtos.add(commonComboDto);
        });
        return commonComboDtos;
    }

}
