package net.zjwu.mis.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.model.Requirement;
import net.zjwu.mis.business.service.RequirementService;

@Service
@Transactional
public class RequirementServiceImpl extends BaseServiceImpl<Requirement> implements RequirementService{

}
