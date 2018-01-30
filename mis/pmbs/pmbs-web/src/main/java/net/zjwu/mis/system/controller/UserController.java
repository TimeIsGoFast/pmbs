/**
 * 
 */
package net.zjwu.mis.system.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.vo.ResultVo;
import net.zjwu.mis.system.model.User;
import net.zjwu.mis.system.service.UserRoleService;
import net.zjwu.mis.system.service.UserService;
import net.zjwu.mis.system.vo.Result;

/**
 * @author Lay
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public PageInfo<User> listUsers(@RequestParam int page,
			@RequestParam int rows, @ModelAttribute User condition) {
		PageInfo<User> pageInfo = userService.listUsersPaged(page, rows,
				condition);
		return pageInfo;
	}

	@RequestMapping(value = "/render")
	public String render(Model model) {
		List<User> list = userService.selectAll();
		model.addAttribute("list", list);
		return "system/user/user";
	}

	@RequestMapping(value = "/saveUserRoles")
	@ResponseBody
	public Result saveUserRoles(@ModelAttribute User user) {
		Result result = new Result();
		try {
			userRoleService.saveUserRoles(user);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/getUsersByRoleId")
	@ResponseBody
	public List<User> getUsersByUserId(@RequestParam int roleId) {
		return userService.getUsersByRoleId(roleId);
	}

	@RequestMapping(value = "/userSelect")
	public String roleSelect(Model model, @RequestParam int roleId) {
		model.addAttribute("roleId", roleId);
		return "select/userSelect";
	}
	@RequestMapping(value="/deleteUser")
	@ResponseBody
	public int deleteUser(int id){
		return userService.delete(id);
	}
	
	//注册
	@RequestMapping("/register")
	@ResponseBody
	public ResultVo register(Model model ,User user){
		ResultVo rs = new ResultVo();
		try{
		User user2 = userService.getUserByUid(user.getUid());
		if(user2 == null){
			Date date = new Date();
			user.setEnabled("Y");
			user.setCreateBy(user.getUid());
			user.setCreateDate(date);
			user.setUpdateBy(user.getUid());
			user.setUpdateDate(date);
			int info = userService.save(user);
			User user3 = userService.getUserByUid(user.getUid());
			userService.initUserRole(user3.getId(),3);
			model.addAttribute("user",user);
			rs.setCode(info);
			rs.setMessage("save success");
		}else{
			rs.setCode(0);
			rs.setMessage("account have already exsist");
		}
		}catch(Exception e){
			rs.setCode(0);
			rs.setMessage("save faild");
		}
		return rs;
	}
}
