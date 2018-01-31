package net.zjwu.mis.business.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import net.zjwu.mis.base.controller.BaseController;
import net.zjwu.mis.business.constans.Constans;
import net.zjwu.mis.business.model.Book;
import net.zjwu.mis.business.model.Sentence;
import net.zjwu.mis.business.service.BookService;
import net.zjwu.mis.business.service.SentenceService;
import net.zjwu.mis.business.vo.ResultVo;
import net.zjwu.mis.system.service.UserService;

@RequestMapping("/book")
@Controller
public class BookController extends BaseController<Book> {
      @Autowired
      private BookService bookService;
      @Autowired
      private SentenceService sentenceService;
      
      @Autowired
      private UserService userService;
      
      @RequestMapping("/render")
      public String render(Model model){
    	  List<Book> list = bookService.selectAll();
    	  model.addAttribute("list", list);
    	  return "system/book/book";
      }
      
      @RequestMapping("/bookDetail/{id}")
      public String bookDeatil(@PathVariable int id,Model model){
    	  boolean isAdd ;
    	  if(id==0){
    		  isAdd=true; 
    	  }else{
    		  Book book = bookService.selectByKey(id);
        	  model.addAttribute("Book", book);
        	  isAdd =false;
    	  }
    	  model.addAttribute("isAdd", isAdd);
    	  return "system/book/book_detail";
      }
      
      /**
       * 添加或修改图书
       */
      @RequestMapping("/bookAddOrUpdate")
      @ResponseBody
      public ResultVo bookAddOrUpdate(Book book){
    	  ResultVo rs = new ResultVo();
    	  rs.setCode(Constans.RESULT_SUCCESS);
    	  rs.setMessage("success");
    	  book.setCreateTime(new Date());
    	  if(book.getId()==null||"".equals(book.getId())){
    		  //add
    		  try{
    		  bookService.save(book);
    		  }catch(Exception e){
    			  rs.setCode(Constans.RESULT_FAIL);
    			  rs.setMessage("add fail");
    		  }
    	  }else{
    		  //update
    		  try{
    		  bookService.update(book);
    		  }catch(Exception e){
    			  rs.setCode(Constans.RESULT_FAIL);
    			  rs.setMessage("update fail");
    		  }
    	  }
    	  return rs;
      }
      
      //得到页面
      @RequestMapping("getSentencePage")
      public String getSentencePage(){
    	  return "system/book/sentence";
      }
      
      @RequestMapping("/getSentenceData")
      @ResponseBody
      public List<Sentence> getSentenceData(int rows,int page){
    	  return sentenceService.getPage(rows,page).getList();
      }
      
      //添加句子页面
      @RequestMapping("/addSentence")
      @ResponseBody
      public ResultVo addSentence(String content){
    	  Sentence sentence = new Sentence();
    	  ResultVo rs = new ResultVo();
    	  rs.setCode(Constans.RESULT_SUCCESS);
    	  rs.setMessage("success");
    	  sentence.setCreatTime(new Date());
    	  sentence.setContent(content);
    	  String uid = (String)SecurityUtils.getSubject().getPrincipal();
    	  String name = userService.getUserByUid(uid).getName();
    	  sentence.setUid(name);
    	  try{
    	  sentenceService.save(sentence);
    	  }catch(Exception e){
    		  rs.setCode(Constans.RESULT_FAIL);
    		  rs.setMessage("save fail");
    	  }
    	  return rs;
      }
      
      //deleteBook
      @RequestMapping("/deleteBook")
      @ResponseBody
      public ResultVo deleteBook(int id){
    	  ResultVo rs = new ResultVo();
    	  rs.setCode(Constans.RESULT_SUCCESS);
    	  try{
    		  bookService.delete(id);
    	  }catch(Exception e){
    		  rs.setCode(Constans.RESULT_FAIL);
    	  }
    	  return rs;
      }
      
      
}
