package net.zjwu.mis.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController<Project> {
	
	@Autowired
	private ProjectService projectService;

}
