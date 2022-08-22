package com.nxg.dao;

import com.nxg.bean.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nxg
 * date 2022/8/8 08 22
 * @apiNote
 */

public interface BookDao {

   public List<Book> getAll();
}
