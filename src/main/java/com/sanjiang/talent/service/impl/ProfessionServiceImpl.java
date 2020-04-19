package com.sanjiang.talent.service.impl;

import com.sanjiang.talent.mapper.ProfessionCourseMapper;
import com.sanjiang.talent.mapper.ProfessionMapper;
import com.sanjiang.talent.po.profession.Profession;
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
}
