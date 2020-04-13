package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.Link;
import com.sanjiang.talent.po.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkMapper {
    @Select("select * from link where type = 1 and link_id = #{loginUserId}")
    List<Link> getLinkRoleByLoginUserId(@Param("loginUserId") String loginUserId);

    @Insert("insert into link(id, role_id, link_id, type) values(#{link.id}, #{link.roleId}, #{link.linkId}, #{link.type})")
    int addRoleMenu(@Param("link") Link link);

    @Delete("delete from link where role_id = #{roleId} and type = 2")
    int deleteRoleMenu(@Param("roleId") String roleId);

    @Delete("delete from link where role_id = #{roleId} and link_id = #{userId} and type = 1")
    int deleteRoleUser(@Param("roleId") String roleId, @Param("userId") String userId);
}
