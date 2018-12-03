package net.zjwu.mis.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.zjwu.mis.business.model.Defect;
import tk.mybatis.mapper.common.Mapper;

public interface DefectMapper extends Mapper<Defect>{

	List<Defect> getAllByProjectId(@Param(value="projectId")int projectId);

	int getNumber(@Param(value="projectId")int projectId);

	Defect getByDefectName(@Param(value="name")String name);

	void addUserDefectMapper(@Param(value="userId")Integer assigneeUid, @Param(value="defectId")Integer id);
    
	void deleteUserAndDefect(@Param(value="userId")Integer assigneeUid, @Param(value="defectId")Integer id);

	List<Defect> getByUserId(@Param(value="userId")Integer id);
}