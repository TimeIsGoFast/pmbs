package net.zjwu.mis.business.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.model.TestPlan;
import net.zjwu.mis.business.service.TestPlanService;
import net.zjwu.mis.business.vo.ResultVo;
import net.zjwu.mis.system.model.User;
import net.zjwu.mis.system.service.UserService;
import net.zjwu.mis.utils.DateFormatUtils;
import net.zjwu.mis.utils.SpringUtil;

@Controller
@RequestMapping("/testplan")
public class TestPlanController extends BaseController<TestPlan> {

	@Autowired
	private TestPlanService testPlanService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("render")
	public String render(Model model){
		Project currentProject = SpringUtil.getCurrentProject();
		List<User> testUsers = userService.getUsersByUserType("测试人员");
		model.addAttribute("testUsers", testUsers);
		List<TestPlan> plans  = testPlanService.getTestPlanByProjectId(currentProject.getId());
		model.addAttribute("plans", plans);
		return "system/testplan/test_plan";
	}
	
	
	//添加测试计划
	@RequestMapping("/addTestPlan")
	@ResponseBody
	public ResultVo addTestPlan(TestPlan  testPlan){
		ResultVo result = new ResultVo();
		result.setCode(1);
		try {
			 User currentUser = SpringUtil.getCurrentUser();
			 Project currentProject = SpringUtil.getCurrentProject();
			if(StringUtils.isEmpty(testPlan.getId())){
				if(testPlanService.getTestPlanByName(testPlan.getName())==null){
					
					 String assignName  = userService.selectByKey(testPlan.getAssignerId()).getName();
					 testPlan.setAssignerName(assignName);
					 testPlan.setAuthor(currentUser.getName());
					 testPlan.setCreateDate(DateFormatUtils.dateToString(new Date()));
					 testPlan.setProjectId(currentProject.getId());
					 testPlan.setCreateUser(currentUser.getName());
					 testPlan.setIsActive(1);
					 testPlan.setIsApproved(true);
					 testPlan.setIsReviewed(0);
					 testPlan.setStatus("未开始");
					 testPlan.setUpdateDate(DateFormatUtils.dateToString(new Date()));
					 testPlan.setUpdateUser(currentUser.getName());
					 testPlanService.save(testPlan);
					 TestPlan testPlan2 = testPlanService.getTestPlanByName(testPlan.getName());
					 testPlanService.addUserPlanMapper(testPlan.getAssignerId(),testPlan2.getId());
					
				}else{
					result.setCode(0);
				}
			}else{
				TestPlan tp1 = testPlanService.selectByKey(testPlan.getId());
				testPlanService.deleteUserAndPlan(tp1.getAssignerId(),testPlan.getId());
				 testPlanService.addUserPlanMapper(testPlan.getAssignerId(),testPlan.getId());
				tp1.setUpdateDate(DateFormatUtils.dateToString(new Date()));
				tp1.setUpdateUser(currentUser.getName());
				tp1.setName(testPlan.getName());
				tp1.setDescr(testPlan.getDescr());
				tp1.setAssignerId(testPlan.getAssignerId());
				User assignUser = userService.selectByKey(testPlan.getAssignerId());
				tp1.setAssignerName(assignUser.getName());
				testPlanService.update(tp1);
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
		}
		return result;
		
	}
	
	//删除project
	@RequestMapping("/deleteplan")
	@ResponseBody
	public ResultVo deleteplan(int  planId){
		ResultVo result = new ResultVo();
		result.setCode(1);
		try {
			TestPlan testplan = testPlanService.selectByKey(planId);
			testPlanService.delete(planId);
			testPlanService.deleteUserAndPlan(testplan.getAssignerId(),planId);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
		}
		return result;
		
	}
	
	@RequestMapping("/getPlanInfo")
	@ResponseBody
	public TestPlan getPlanInfo(int planId){
		return testPlanService.selectByKey(planId);
	}
	
}
