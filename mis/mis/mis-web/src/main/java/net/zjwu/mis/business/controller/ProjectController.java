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
import net.zjwu.mis.business.dto.UserDto;
import net.zjwu.mis.business.model.Project;
import net.zjwu.mis.business.model.ProjectUserRole;
import net.zjwu.mis.business.service.ProjectService;
import net.zjwu.mis.business.service.ProjectUserRoleService;
import net.zjwu.mis.business.vo.ResultVo;
import net.zjwu.mis.system.model.Role;
import net.zjwu.mis.system.model.User;
import net.zjwu.mis.system.service.RoleService;
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
	
	@Autowired
	private RoleService roleService;
	
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
	public String projectUserRender(Model model,int projectId){
		//get role
		List<Role> roles = roleService.getRolesByRemark("PROJECT");
		List<User> users2 = userService.selectAll(); 
		List<UserDto> users = projectService.getProjefctUsers(projectId);
		Project pro = projectService.selectByKey(projectId);
		model.addAttribute("roles", roles);
		model.addAttribute("users", users);
		model.addAttribute("users2", users2);
		model.addAttribute("project", pro);
		return "system/project/project_users";
	}
	
	//addProjectUserRole
	@RequestMapping("/addProjectUserRole")
	@ResponseBody
	public ResultVo addProjectUserRole(int  projectId,int userId,int roleId){
		ResultVo result = new ResultVo();
		result.setCode(1);
		try {
			 ProjectUserRole pjur = new ProjectUserRole();
			 pjur.setProjectId(projectId);
			 pjur.setUserId(userId);
			 pjur.setRoleId(roleId);
			 projectUserRoleService.save(pjur);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
		}
		return result;
		
	}
	
	//deleteProjectUserRole
	@RequestMapping("/deleteProjectUserRole")
	@ResponseBody
	public ResultVo deleteProjectUserRole(int  projectId,int userId,int roleId){
		ResultVo result = new ResultVo();
		result.setCode(1);
		try {
			 projectUserRoleService.deleteByProjectId(projectId,userId,roleId);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
		}
		return result;
		
	}
	
	//Myproject
	@RequestMapping("/myproject")
	public String myproject(Model model){
		int userId = SpringUtil.getCurrentUser().getId();
		List<Project> list = projectService.getMyProjects(userId);
		List<User> users = userService.selectAll();
		model.addAttribute("projects", list);
		model.addAttribute("users", users);
		return "system/project/project";
	}
}
