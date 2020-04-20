package com.sanjiang.talent.service;

import com.sanjiang.talent.po.profession.Profession;
import com.sanjiang.talent.po.profession.ProfessionCourse;

import java.util.List;
import java.util.Map;

public interface ProfessionService {
    /**
     * 获取专业列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getProfessionManage(Integer page, Integer rows);
    /**
     * 新增专业
     * @param profession
     */
    void createProfession(Profession profession);

    /**
     * 删除专业
     * @param ids
     */
    void deleteProfession(List<String> ids);

    /**
     * 获取专业combobox
     * @param q
     * @return
     */
    List<Profession> getProfession(String q);

    /**
     * 获取课程专业列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getProfessionCourseManage(Integer page, Integer rows, String professionId, String courseId);
    /**
     * 新增课程专业
     * @param professionCourse
     */
    void createProfessionCourse(ProfessionCourse professionCourse);

    /**
     * 删除课程专业
     * @param ids
     */
    void deleteProfessionCourse(List<String> ids);

}
