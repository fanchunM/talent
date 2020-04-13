package com.sanjiang.talent.mapper;

import com.sanjiang.talent.vo.MenuDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    @Select("select m.id, m.name, m.address, m.icon from menu m right join link l on l.link_id = m.id where l.role_id = #{roleId} and l.type = 2 and m.father_id is null")
    List<MenuDto> getFatherMenuByRoleId(@Param("roleId") String roleId);

    @Select("select m.id, m.name, m.address, m.icon from menu m where m.father_id is null")
    List<MenuDto> getFatherMenu();

    @Select("select m.id, m.name, m.address, m.icon from menu m right join link l on l.link_id = m.id where l.role_id = #{roleId} and l.type = 2 and m.father_id = #{fatherId}")
    List<MenuDto> getChildrenMenuByRoleId(@Param("roleId") String roleId, @Param("fatherId") String fatherId);

    @Select("select m.id, m.name, m.address, m.icon from menu m where m.father_id = #{fatherId}")
    List<MenuDto> getChildrenMenu(@Param("fatherId") String fatherId);

    @Select("select m.id from menu m right join link l on l.link_id = m.id where l.role_id = #{roleId} and l.type = 2")
    List<String> getRoleMenu(@Param("roleId") String roleId);

    @Select("select * from menu where id = #{id}")
    MenuDto getMenuById(@Param("id") String id);
}
