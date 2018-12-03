package net.zjwu.mis.business.controller;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Defect;
import net.zjwu.mis.business.model.TestPlan;
import net.zjwu.mis.business.service.DefectService;
import net.zjwu.mis.business.service.TestPlanService;
import net.zjwu.mis.business.vo.ResultVo;
import net.zjwu.mis.system.model.User;
import net.zjwu.mis.system.service.UserService;
import net.zjwu.mis.utils.DateFormatUtils;
import net.zjwu.mis.utils.PropertyUtil;
import net.zjwu.mis.utils.SpringUtil;

@Controller
@RequestMapping("/defect")
public class DefectController extends BaseController<Defect>{
    
	@Autowired
	private DefectService defectService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private TestPlanService testPlanService;
	
	@RequestMapping("/render")
	public String render(Model model){
		int projectId  = SpringUtil.getCurrentProject().getId();
		List<Defect> defects = defectService.getAllByProjectId(projectId);
		List<User> users = userService.getUsersByUserType("开发人员");
		List<TestPlan> testPlans = testPlanService.getTestPlanByProjectId(projectId);
		model.addAttribute("users", users);
		model.addAttribute("testPlans", testPlans);
		model.addAttribute("defects", defects);
		return "system/defect/defect";
	}
	
	 @RequestMapping("/addDefect")
     public String addDefect(Defect defect,@RequestParam MultipartFile defect_pic,HttpServletRequest request,Model model) throws IllegalStateException, IOException{
	  int projectId  = SpringUtil.getCurrentProject().getId();
	  User currentUser = SpringUtil.getCurrentUser();
   	  String originalFilename = defect_pic.getOriginalFilename();
 		  if(defect_pic!=null && originalFilename!=null && originalFilename.length()>0){
 			//得到保存路径
 			String savepath = PropertyUtil.getProperty("book.uplod.url");
 			//得到新的图片名称
 			String filename = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
 			String picUrl = "defect"+File.separator+filename;
 			File newfile = new File(savepath+picUrl);
 			//将图片存到硬盘里
 			defect_pic.transferTo(newfile);
 			//将图片名称存到数据库
 			defect.setPicUrl(picUrl);
 		  }
 		int number = defectService.getNumber(projectId);  
 		String str = String.format("%04d", number+1);
 		defect.setName(SpringUtil.getCurrentProject().getShortname()+"_"+str); 
 		defect.setStatus("分析"); 
 		defect.setResolution("未解决");
 		defect.setProjectId(projectId);
 		defect.setCreatorUid(currentUser.getId());
 		defect.setCreatorName(currentUser.getName());
 		User assignUser = userService.selectByKey(defect.getAssigneeUid());
 		if(assignUser!=null){
 			defect.setAssigneeName(assignUser.getName());
 		}
 		defect.setCreatedDate(DateFormatUtils.dateToString(new Date()));
 		defect.setUpdateUid(currentUser.getId());
 		defect.setUpdateDate(DateFormatUtils.dateToString(new Date()));
 		defectService.save(defect);
 		
 		Defect defect2 = defectService.getByDefectName(SpringUtil.getCurrentProject().getShortname()+"_"+str);
 		defectService.addUserDefectMapper(defect2.getAssigneeUid(),defect2.getId());
 		List<Defect> defects = defectService.getAllByProjectId(projectId);
 		List<User> users = userService.getUsersByUserType("开发人员");
 		List<TestPlan> testPlans = testPlanService.getTestPlanByProjectId(projectId);
 		model.addAttribute("users", users); 
 		model.addAttribute("testPlans", testPlans);
 		model.addAttribute("defects", defects);
 		return "system/defect/defect";  
   	
     }
	 
	 @RequestMapping("/getDetail")
	 public String getDetail(int defectId,Model model){
		 Defect defect = defectService.selectByKey(defectId);
		 TestPlan testPlan = testPlanService.selectByKey(defect.getPlanId());
		 List<User> users = userService.getUsersByUserType("开发人员");
		 model.addAttribute("defect", defect);
		 model.addAttribute("testPlan", testPlan);
		 model.addAttribute("users", users);
		 return "system/defect/defect_detail";
	 }
	 
		@RequestMapping("/updateStatus")
		@ResponseBody
		public ResultVo deleteplan(int code,int defectId,String  resolution){
			ResultVo result = new ResultVo();
			result.setCode(1);
			User user = SpringUtil.getCurrentUser();
			Defect defect = defectService.selectByKey(defectId);
			defect.setUpdateDate(DateFormatUtils.dateToString(new Date()));
		    defect.setUpdateUid(user.getId());
			try {
				if(code==1){
				    defect.setResolution(resolution);
				    defectService.update(defect);
				}else{
					int assignId = Integer.parseInt(resolution);
					User assignUser = userService.selectByKey(assignId);
					
					defectService.deleteUserDefectMapper(defect.getAssigneeUid(),defect.getId());
					defect.setAssigneeName(assignUser.getName());
					defect.setAssigneeUid(assignId);
					defectService.addUserDefectMapper(assignId,defect.getId());
					defectService.update(defect);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				result.setCode(0);
			}
			return result;
			
		}
	
}
