package net.zjwu.mis.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.model.Defect;
import net.zjwu.mis.business.service.DefectService;

@Service
@Transactional
public class DefectServiceImpl extends BaseServiceImpl<Defect> implements DefectService{

}
