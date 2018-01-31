/**
 * 
 */
package net.zjwu.mis.system.service;

import java.util.List;

import net.zjwu.mis.base.service.BaseService;
import net.zjwu.mis.system.model.User;

import com.github.pagehelper.PageInfo;

/**
 * @author Lay
 *
 */
public interface UserService extends BaseService<User>{
	
	List<User> listUsers();
	
	PageInfo<User> listUsersPaged(int page,int pageSize,User user);
	
	List<User> getUsersByRoleId(int roleId);
	
	User getUserByUid(String uid);

	void initUserRole(Integer id, int i);
}
