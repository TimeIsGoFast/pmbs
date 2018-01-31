package net.zjwu.mis.business.service;

import com.github.pagehelper.PageInfo;

import net.zjwu.mis.base.service.BaseService;
import net.zjwu.mis.business.model.Sentence;

public interface SentenceService extends BaseService<Sentence>{

	PageInfo<Sentence> getPage(int rows, int page);

}
