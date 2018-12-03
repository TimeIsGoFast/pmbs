package net.zjwu.mis.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.zjwu.mis.business.model.TestPlan;
import tk.mybatis.mapper.common.Mapper;

public interface TestPlanMapper extends Mapper<TestPlan> {

	TestPlan getTestPlanByName(@Param(value="name")String name);

	void addUserPlanMapper(@Param(value="userId")Integer userId, @Param(value="planId")Integer planId);

	void deleteUserAndPlan(@Param(value="userId")Integer assignerId, @Param(value="planId")int planId);

	List<TestPlan> getTestPlanByProjectId(@Param(value="projectId")Integer id);

	List<TestPlan> getByUserId(@Param(value="userId")Integer id);
    
}