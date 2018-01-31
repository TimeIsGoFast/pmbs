package net.zjwu.mis.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.model.Book;

@RequestMapping("/tourist")
@Controller
public class TouristController extends BaseController<Book>{

}
