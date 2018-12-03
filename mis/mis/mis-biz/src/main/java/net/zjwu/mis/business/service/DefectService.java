package net.zjwu.mis.business.service;

import java.util.List;

import net.zjwu.mis.base.service.BaseService;
import net.zjwu.mis.business.model.Defect;

public interface DefectService extends BaseService<Defect>{

	List<Defect> getAllByProjectId(int projectId);

	int getNumber(int projectId);

	Defect getByDefectName(String name);

	void addUserDefectMapper(Integer assigneeUid, Integer id);

	void deleteUserDefectMapper(Integer assigneeUid, Integer id);

	List<Defect> getByUserId(Integer id);

}
