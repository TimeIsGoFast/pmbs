package net.zjwu.mis.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{

}
