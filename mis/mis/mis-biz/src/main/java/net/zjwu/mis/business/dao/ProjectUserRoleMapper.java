package net.zjwu.mis.business.dao;

import org.apache.ibatis.annotations.Param;

import net.zjwu.mis.business.model.ProjectUserRole;
import tk.mybatis.mapper.common.Mapper;

public interface ProjectUserRoleMapper extends Mapper<ProjectUserRole>{

	void deleteByProjectId(@Param(value="projectId")int projectId, @Param(value="userId")int userId, @Param(value="roleId")int roleId);
   
}