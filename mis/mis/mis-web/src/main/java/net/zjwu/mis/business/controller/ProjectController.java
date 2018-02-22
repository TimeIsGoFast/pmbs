package net.zjwu.mis.business.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.model.ProjectUserRole;
import net.zjwu.mis.business.service.ProjectService;
import net.zjwu.mis.business.service.ProjectUserRoleService;
import net.zjwu.mis.business.vo.ResultVo;
import net.zjwu.mis.system.model.User;
import net.zjwu.mis.system.service.UserService;
import net.zjwu.mis.utils.SpringUtil;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController<Project> {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectUserRoleService projectUserRoleService;
	
	@RequestMapping("/render")
	public String render(Model model){
		List<Project> list = projectService.selectAll();
		List<User> users = userService.selectAll();
		model.addAttribute("projects", list);
		model.addAttribute("users", users);
		return "system/project/project";
	}
	
	//添加或者修改project
	@RequestMapping("/addEditPro")
	@ResponseBody
	public ResultVo addEditPro(Project project){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		ResultVo result = new ResultVo();
		int ownerId = project.getOwnerId();
		String ownerName = userService.selectByKey(ownerId).getName();
		String userName = SpringUtil.getCurrentUser().getName();
		project.setCreatedDt(format.format(date));
		project.setCreatedUser(userName);
		project.setOwnerName(ownerName);
		result.setCode(1);
		try {
			if(project.getId()==null){
				//判断重名
				List<Project> pjs = projectService.virefProjectName(project.getName());
				if(pjs.isEmpty()){
			    projectService.save(project);
			    //添加关系
			    Project project2 = projectService.getProjectByProjectName(project.getName());
			    ProjectUserRole pjur = new ProjectUserRole();
			    pjur.setProjectId(project2.getId());
			    pjur.setUserId(SpringUtil.getCurrentUser().getId());
			    pjur.setRoleId(1);
			    projectUserRoleService.save(pjur);
				}else{
					result.setCode(3);
				}
			}else{
				projectService.update(project);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
		}
		return result;
		
	}
	
	//删除project
	@RequestMapping("/deletePro")
	@ResponseBody
	public ResultVo deletePro(int  projectId){
		ResultVo result = new ResultVo();
		result.setCode(1);
		try {
			projectService.delete(projectId);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
		}
		return result;
		
	}
	
	//getProjectInfo
	@RequestMapping("/getProjectInfo")
	@ResponseBody
	public Project getProjectInfo(int projectId){
		return projectService.selectByKey(projectId);
	}
	
	//projectUser index
	@RequestMapping("/projectUserRender")
	public String projectUserRender(Model nodel,int projectId){
		//得到所有的用户信息
		
		return "system/project/project_users";
	}

}
