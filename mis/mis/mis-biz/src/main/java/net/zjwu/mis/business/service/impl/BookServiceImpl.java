package net.zjwu.mis.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.zjwu.mis.base.service.impl.BaseServiceImpl;
import net.zjwu.mis.business.model.Book;
import net.zjwu.mis.business.service.BookService;

@Transactional
@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {

}
