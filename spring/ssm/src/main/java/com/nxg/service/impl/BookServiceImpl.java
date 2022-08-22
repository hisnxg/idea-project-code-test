package com.nxg.service.impl;

import com.nxg.bean.Book;
import com.nxg.dao.BookDao;
import com.nxg.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nxg
 * date 2022/8/8 08 23
 * @apiNote
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    public List<Book> getAll() {
        List<Book> all = bookDao.getAll();
        System.out.println(all);
        return all;
    }
}
