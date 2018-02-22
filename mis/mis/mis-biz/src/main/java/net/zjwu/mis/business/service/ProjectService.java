package net.zjwu.mis.business.service;

import java.util.List;

import net.zjwu.mis.base.service.BaseService;
import net.zjwu.mis.business.model.Project;

public interface ProjectService extends BaseService<Project>{

	List<Project> virefProjectName(String name);

	Project getProjectByProjectName(String name);

}
