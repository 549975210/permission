package com.hu.dao;

import com.hu.model.SysUser;
import com.hu.util.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(@Param("id")Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(@Param("id")Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int countByDeptId(@Param("deptId") int deptId);

    int countByMail(@Param("mail")String mail, @Param("id")Integer id);

    int countByPhone(@Param("phone")String phone, @Param("id")Integer id);

    SysUser findByKeyword(@Param("keyword") String keyword);

    List<SysUser> getPageByDeptId(@Param("deptId") int deptId, @Param("page") PageQuery page);

    List<SysUser> getByIdList(@Param("idList") List<Integer> idList);

    List<SysUser> getAll();
}