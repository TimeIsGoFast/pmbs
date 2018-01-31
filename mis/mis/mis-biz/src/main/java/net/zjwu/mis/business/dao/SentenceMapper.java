package net.zjwu.mis.business.dao;

import java.util.List;

import net.zjwu.mis.business.model.Sentence;
import tk.mybatis.mapper.common.Mapper;

public interface SentenceMapper extends Mapper<Sentence> {

	List<Sentence> getPage();
}