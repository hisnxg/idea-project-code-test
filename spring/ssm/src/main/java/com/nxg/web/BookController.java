package com.nxg.web;

import com.nxg.bean.Book;
import com.nxg.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nxg
 * date 2022/8/8 08 24
 * @apiNote
 */
@Controller
public class BookController {
    
    @Resource
    private BookService bookService;
    
    @RequestMapping("/getAllBook")
    public String getAll(ModelMap modelMap){
        List<Book> bookList = bookService.getAll();
        modelMap.addAttribute("bookList",bookList);
        return "show";
    }
}
