package com.liang.controller;

import com.liang.pojo.Books;
import com.liang.service.BookService;
import com.liang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }
    @RequestMapping("/toAddPage")
    public String toAddPage(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";        //重定向到首页
    }

    @RequestMapping("toUpdatePage")
    public String toUpdatePage(int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook", books);
        return "updateBook";
    }
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("deleteBook/{booId}")
    public String deleteBook(@PathVariable int booId){
        System.out.println("deleteBook=>"+booId);
        bookService.deleteBook(booId);
        return "redirect:/book/allBook";
    }
    @RequestMapping("queryBook")
    public String queryBookByName(String queryBookName, Model model){
        Books book = bookService.queryBookByName(queryBookName);
        ArrayList<Books> books = new ArrayList<>();
        books.add(book);
        model.addAttribute("list", books);
        return "allBook";
    }

}
