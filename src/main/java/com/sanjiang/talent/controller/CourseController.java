package com.sanjiang.talent.controller;

import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.CourseUnits;
import com.sanjiang.talent.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createMoudle(@RequestBody Course course) {
        courseService.createCourse(course);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("delete_course")
    public ResponseEntity<String> deleteMoudle(@RequestBody List<String> ids) {
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

}
