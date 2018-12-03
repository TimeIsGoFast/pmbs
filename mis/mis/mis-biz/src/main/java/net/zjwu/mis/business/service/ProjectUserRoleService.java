package net.zjwu.mis.business.service;

import net.zjwu.mis.base.service.BaseService;
import net.zjwu.mis.business.model.ProjectUserRole;

public interface ProjectUserRoleService extends BaseService<ProjectUserRole>{

	void deleteByProjectId(int projectId, int userId, int roleId);

	void deleteByProId(int projectId);

}
