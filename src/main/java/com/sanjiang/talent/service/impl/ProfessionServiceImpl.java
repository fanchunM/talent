package com.sanjiang.talent.service.impl;

import com.sanjiang.talent.mapper.*;
import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.Moudle;
import com.sanjiang.talent.po.course.Platform;
import com.sanjiang.talent.po.profession.Profession;
import com.sanjiang.talent.po.profession.ProfessionCourse;
import com.sanjiang.talent.service.ProfessionService;
import com.sanjiang.talent.util.VGUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private ProfessionCourseMapper professionCourseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private MoudleMapper moudleMapper;
    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public Map<String, Object> getProfessionManage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(5);
        List<Profession> professions = professionMapper.getProfessionManage((page-1)*rows, rows);
        Integer professionCount = professionMapper.getProfessionCount();
        map.put("total", professionCount);
        map.put("rows", professions);
        return map;
    }

    @Override
    public void createProfession(Profession profession) {
        if (!VGUtility.isEmpty(profession.getId())) {
            professionMapper.updateProfession(profession);
        } else {
            profession.setId(UUID.randomUUID().toString().replace("-", ""));
            professionMapper.createProfession(profession);
        }
    }

    @Override
    public void deleteProfession(List<String> ids) {
        professionMapper.deleteProfession(ids);
    }

    @Override
    public List<Profession> getProfession(String q) {
        return professionMapper.getProfession(q);
    }

    @Override
    public Map<String, Object> getProfessionCourseManage(Integer page, Integer rows, String professionId, String courseId) {
        Map<String, Object> map = new HashMap<>(5);
        List<ProfessionCourse> professionCourses = professionCourseMapper.getProfessionCourseManage((page-1)*rows, rows, professionId, courseId);
        professionCourses.stream().forEach(o -> {
            String courseId2 = o.getCourseId();
            String professionId2 = o.getProfessionId();
            Profession professionById = professionMapper.getProfessionById(professionId2);
            Course courseById = courseMapper.getCourseById(courseId2);
            String moudleId = courseById.getMoudleId();
            Moudle moudleById = moudleMapper.getMoudleById(moudleId);
            String platformId = moudleById.getPlatformId();
            Platform platformById = platformMapper.getPlatformById(platformId);
            o.setPlatformName(platformById.getName());
            o.setMoudleName(moudleById.getName());
            o.setCourseCode(courseById.getCode());
            o.setCourseName(courseById.getName());
            o.setProfessionName(professionById.getName());
        });
        Integer professionCourseCount = professionCourseMapper.getProfessionCourseCount();
        map.put("total", professionCourseCount);
        map.put("rows", professionCourses);
        return map;
    }

    @Override
    public void createProfessionCourse(ProfessionCourse professionCourse) {
        if (!VGUtility.isEmpty(professionCourse.getId())) {
            professionCourseMapper.updateProfessionCourse(professionCourse);
        } else {
            professionCourse.setId(UUID.randomUUID().toString().replace("-", ""));
            professionCourseMapper.createProfessionCourse(professionCourse);
        }
    }

    @Override
    public void deleteProfessionCourse(List<String> ids) {
        professionCourseMapper.deleteProfessionCourse(ids);
    }
}
