package net.zjwu.mis.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.dao.DefectMapper;
import net.zjwu.mis.business.model.Defect;
import net.zjwu.mis.business.service.DefectService;

@Service
@Transactional
public class DefectServiceImpl extends BaseServiceImpl<Defect> implements DefectService{

	@Autowired
	private DefectMapper defectMapper;
	@Override
	public List<Defect> getAllByProjectId(int projectId) {
		return defectMapper.getAllByProjectId(projectId);
	}
	@Override
	public int getNumber(int projectId) {
		
		return defectMapper.getNumber(projectId);
	}
	@Override
	public Defect getByDefectName(String name) {
		return defectMapper.getByDefectName(name);
	}
	@Override
	public void addUserDefectMapper(Integer assigneeUid, Integer id) {
		defectMapper.addUserDefectMapper(assigneeUid,id);
		
	}
	@Override
	public void deleteUserDefectMapper(Integer assigneeUid, Integer id) {
		defectMapper.deleteUserAndDefect(assigneeUid, id);
		
	}
	@Override
	public List<Defect>  getByUserId(Integer id) {
		return defectMapper.getByUserId(id);
	}

}
