package net.zjwu.mis.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Requirement;
import net.zjwu.mis.business.service.RequirementService;

@Controller
@RequestMapping("/require")
public class RequirementController extends BaseController<Requirement> {

	@Autowired
	private RequirementService requireService;
	
	
}
