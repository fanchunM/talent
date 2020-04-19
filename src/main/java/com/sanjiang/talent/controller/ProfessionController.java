package com.sanjiang.talent.controller;

import com.sanjiang.talent.po.profession.Profession;
import com.sanjiang.talent.service.ProfessionService;
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
@SessionAttributes(value = {"loginUserDto"})
@RequestMapping(value = "/profession/")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @GetMapping("profession_manage")
    public Map<String, Object> getProfessionManage(@RequestParam(defaultValue = "1") String page,
                                                   @RequestParam(defaultValue = "20") String rows) {

        return professionService.getProfessionManage(Integer.valueOf(page), Integer.valueOf(rows));
    }

    @PostMapping("create_profession")
    public ResponseEntity<String> createProfession(@RequestBody Profession profession) {
        professionService.createProfession(profession);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("delete_profession")
    public ResponseEntity<String> deleteProfession(@RequestBody List<String> ids) {
        log.info("delete Profession where id in {}", ids);
        professionService.deleteProfession(ids);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @GetMapping("get_profession")
    public List<CommonComboDto> getCourseCombobox(@RequestParam(defaultValue = "") String q) {
        List<Profession> moudles = professionService.getProfession(q);
        List<CommonComboDto> commonComboDtos = new ArrayList<>();
        moudles.stream().forEach(o -> {
            CommonComboDto commonComboDto = new CommonComboDto();
            commonComboDto.setValue(o.getId());
            commonComboDto.setText(o.getCodeIn() + "  " + o.getName());
            commonComboDtos.add(commonComboDto);
        });
        return commonComboDtos;
    }
}
