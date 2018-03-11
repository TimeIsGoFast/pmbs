package net.zjwu.mis.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.dao.ProjectMapper;
import net.zjwu.mis.business.dto.UserDto;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.service.ProjectService;
import net.zjwu.mis.system.dao.UserMapper;

@Service
@Transactional
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{
    @Autowired
    private ProjectMapper projectMapper;
    
    @Autowired
    private UserMapper userMapper;
	
	@Override
	public List<Project> virefProjectName(String name) {
		return projectMapper.virefProjectName(name);
	}

	@Override
	public Project getProjectByProjectName(String name) {
		return projectMapper.getProjectByProjectName(name);
	}

	@Override
	public List<UserDto> getProjefctUsers(int projectId) {
		return userMapper.getProjefctUsers(projectId);
	}

	@Override
	public List<Project> getMyProjects(int userId) {
		return projectMapper.getMyProjects(userId);
	}

}
