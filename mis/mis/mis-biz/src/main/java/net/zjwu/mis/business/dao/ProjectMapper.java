package net.zjwu.mis.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.zjwu.mis.business.model.Project;
import tk.mybatis.mapper.common.Mapper;

public interface ProjectMapper extends Mapper<Project> {

	List<Project> virefProjectName(@Param(value="name")String name);

	Project getProjectByProjectName(@Param(value="name")String name);

	List<Project> getMyProjects(@Param(value="userId")int userId);
}