package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkMapper {
    @Select("select * from link where type = 1 and link_id = #{loginUserId}")
    List<Role> getLinkRoleByLoginUserId(@Param("loginUserId") String loginUserId);
}
