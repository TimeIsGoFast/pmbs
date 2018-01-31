package net.zjwu.mis.system.dao;

import java.util.List;

import net.zjwu.mis.system.model.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
	User getUserByUid(String uid);

	User getUserWithRolesByUid(String uid);
	
	List<User> getUsersByRoleId(int roleId);
}