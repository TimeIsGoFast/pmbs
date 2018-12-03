package net.zjwu.mis.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.zjwu.mis.business.model.Defect;
import net.zjwu.mis.business.model.TestPlan;
import net.zjwu.mis.business.service.DefectService;
import net.zjwu.mis.business.service.TestPlanService;
import net.zjwu.mis.system.model.User;
import net.zjwu.mis.utils.SpringUtil;

@Controller
@RequestMapping("/task")
public class TaskController {
   
	@Autowired
	private DefectService defectService;
	
	@Autowired
	private TestPlanService testPlanService;
	
	@RequestMapping("/render")
	public String render(Model model){
		User currentUser = SpringUtil.getCurrentUser();
		if(currentUser.getRemark().equals("开发人员")){
			List<Defect> defects = defectService.getByUserId(currentUser.getId());
			model.addAttribute("defects", defects);
		}else{
			List<TestPlan> testplans = testPlanService.getByUserId(currentUser.getId());
			model.addAttribute("testplans", testplans);
		}
		
		return "system/mytask";
	}
}
