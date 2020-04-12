package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> getRoleManage(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows);

    @Select("select count(*) from role")
    Integer getRoleCount();

    void createRole(Role role);

    @Update("update role set role_name = #{role.roleName} where id = #{role.id}")
    int updateRole(@Param("role") Role role);

    int deleteRole(@Param("idList") List<String> idList);
}
