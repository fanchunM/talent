package com.sanjiang.talent.service.impl;

import com.sanjiang.talent.mapper.CourseMapper;
import com.sanjiang.talent.mapper.CourseUnitsMapper;
import com.sanjiang.talent.mapper.MoudleMapper;
import com.sanjiang.talent.mapper.PlatformMapper;
import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.CourseUnits;
import com.sanjiang.talent.po.course.Moudle;
import com.sanjiang.talent.service.CourseService;
import com.sanjiang.talent.util.VGUtility;
import com.sanjiang.talent.vo.CommonComboDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseUnitsMapper courseUnitsMapper;
    @Autowired
    private MoudleMapper moudleMapper;
    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public Map<String, Object> getCourseManage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(5);
        List<Course> courses = courseMapper.getCourseManage((page-1)*rows, rows);
        courses.stream().forEach(o -> {
            String moudleId = o.getMoudleId();
            Moudle moudleById = moudleMapper.getMoudleById(moudleId);
            o.setMoudleName(moudleById.getName());
            o.setPlatformName(platformMapper.getPlatformById(moudleById.getPlatformId()).getName());
            CourseUnits courseUnitsById = courseUnitsMapper.getCourseUnitsById(o.getCourseUnitsId());
            o.setCourseUnitsName(courseUnitsById.getName());
        });
        Integer courseCount = courseMapper.getCourseCount();
        map.put("total", courseCount);
        map.put("rows", courses);
        return map;
    }

    @Override
    public void createCourse(Course course) {
        if (!VGUtility.isEmpty(course.getId())) {
            courseMapper.updateCourse(course);
        } else {
            course.setId(UUID.randomUUID().toString().replace("-", ""));
            courseMapper.createCourse(course);
        }
    }

    @Override
    public void deleteCourse(List<String> ids) {
        courseMapper.deleteCourse(ids);
    }

    @Override
    public Map<String, Object> getCourseUnitsManage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(5);
        List<CourseUnits> courseUnits = courseUnitsMapper.getCourseUnitsManage((page-1)*rows, rows);
        Integer courseUnitsCount = courseUnitsMapper.getCourseUnitsCount();
        map.put("total", courseUnitsCount);
        map.put("rows", courseUnits);
        return map;
    }

    @Override
    public void createCourseUnits(CourseUnits courseUnits) {
        if (!VGUtility.isEmpty(courseUnits.getId())) {
            courseUnitsMapper.updateCourseUnits(courseUnits);
        } else {
            courseUnits.setId(UUID.randomUUID().toString().replace("-", ""));
            courseUnitsMapper.createCourseUnits(courseUnits);
        }
    }

    @Override
    public void deleteCourseUnits(List<String> ids) {
        courseUnitsMapper.deleteCourseUnits(ids);
    }

    @Override
    public List<Course> getCourse(String q) {
        return courseMapper.getCourse(q);
    }

    @Override
    public List<CommonComboDto> getCourseUnitsForCombo(String q) {
        List<CourseUnits> courseUnits = courseUnitsMapper.getCourseUnits(q);
        List<CommonComboDto> commonComboDtos = new ArrayList<CommonComboDto>();
        courseUnits.stream().forEach(o -> {
            CommonComboDto commonComboDto = new CommonComboDto();
            commonComboDto.setValue(o.getId());
            commonComboDto.setText(o.getName());
            commonComboDtos.add(commonComboDto);
        });
        return commonComboDtos;
    }
}
