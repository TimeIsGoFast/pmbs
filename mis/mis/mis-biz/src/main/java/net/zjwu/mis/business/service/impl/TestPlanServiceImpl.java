package net.zjwu.mis.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.dao.TestPlanMapper;
import net.zjwu.mis.business.model.TestPlan;
import net.zjwu.mis.business.service.TestPlanService;

@Service
@Transactional
public class TestPlanServiceImpl extends BaseServiceImpl<TestPlan> implements TestPlanService{
    
	@Autowired
	private TestPlanMapper testPlanMapper;
	@Override
	public TestPlan getTestPlanByName(String name) {
		return testPlanMapper.getTestPlanByName(name);
	}
	@Override
	public void addUserPlanMapper(Integer userId, Integer planId) {
		testPlanMapper.addUserPlanMapper(userId,planId);
		
	}
	@Override
	public void deleteUserAndPlan(Integer assignerId, int planId) {
		testPlanMapper.deleteUserAndPlan(assignerId,planId);
		
	}
	@Override
	public List<TestPlan> getTestPlanByProjectId(Integer id) {
		return testPlanMapper.getTestPlanByProjectId(id);
	}
	@Override
	public List<TestPlan> getByUserId(Integer id) {
		return testPlanMapper.getByUserId(id);
	}

}
