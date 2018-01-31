package net.zjwu.mis.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Defect;
import net.zjwu.mis.business.service.DefectService;

@Controller
@RequestMapping("/defect")
public class DefectController extends BaseController<Defect>{
    
	@Autowired
	private DefectService defectService;
	
	
}
