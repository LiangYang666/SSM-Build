package com.liang.service;

import com.liang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books books);

    int deleteBook(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    Books queryBookByName(String name);

    List<Books> queryAllBook();
}
