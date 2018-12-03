package net.zjwu.mis.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.dao.ProjectUserRoleMapper;
import net.zjwu.mis.business.model.ProjectUserRole;
import net.zjwu.mis.business.service.ProjectUserRoleService;

@Service
@Transactional
public class ProjectUserRoleServiceImpl extends BaseServiceImpl<ProjectUserRole> implements ProjectUserRoleService{

	@Autowired
	private ProjectUserRoleMapper purMapper;
	@Override
	public void deleteByProjectId(int projectId, int userId, int roleId) {
		purMapper.deleteByProjectId(projectId,userId,roleId);
		
	}
	@Override
	public void deleteByProId(int projectId) {
		purMapper.deleteByProId(projectId);
		
	}


}
