package net.zjwu.mis.business.service;

import java.util.List;

import net.zjwu.mis.base.service.BaseService;
import net.zjwu.mis.business.model.TestPlan;

public interface TestPlanService extends BaseService<TestPlan>{

	TestPlan getTestPlanByName(String name);

	void addUserPlanMapper(Integer userId, Integer planId);

	void deleteUserAndPlan(Integer assignerId, int planId);

	List<TestPlan> getTestPlanByProjectId(Integer id);

	List<TestPlan> getByUserId(Integer id);

}
