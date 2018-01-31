package net.zjwu.mis.business.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.dao.SentenceMapper;
import net.zjwu.mis.business.model.Sentence;
import net.zjwu.mis.business.service.SentenceService;

@Service
@Transactional
public class SentenceServiceImpl extends BaseServiceImpl<Sentence> implements SentenceService {
    
	@Autowired
	private SentenceMapper sentenceMapper;
	@Override
	public PageInfo<Sentence> getPage(int rows, int page) {
		PageHelper.startPage(page, rows);
		List<Sentence> list = sentenceMapper.getPage();
		PageInfo<Sentence> pages = new PageInfo<Sentence>(list);
		return pages;
	}



}
