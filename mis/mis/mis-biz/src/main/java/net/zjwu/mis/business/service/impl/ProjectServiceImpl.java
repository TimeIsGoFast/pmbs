package net.zjwu.mis.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.dao.ProjectMapper;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{
    @Autowired
    private ProjectMapper projectMapper;
	
	@Override
	public List<Project> virefProjectName(String name) {
		return projectMapper.virefProjectName(name);
	}

	@Override
	public Project getProjectByProjectName(String name) {
		return projectMapper.getProjectByProjectName(name);
	}

}
