package net.zjwu.mis.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.zjwu.mis.system.model.Role;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {

	List<Role> getRolesByUserId(int userId);

	List<Role> getRolesByUid(String uid);

	List<Role> getRolesByRemark(@Param(value="remark")String remark);
}