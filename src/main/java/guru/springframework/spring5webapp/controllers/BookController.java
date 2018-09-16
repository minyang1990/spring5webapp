package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 5/18/17.
 */
@Controller
//会变成spring bean  spring managw component
public class BookController {

    private BookRepository bookRepository;

    //    由于这里有constroctor 这里会auto wired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //这个会invok 只要url request book进来
    @RequestMapping("/books")
    public String getBooks(Model model){
        //把所有jpa 数据库里的书本拿出来 绑定books srtring 和所有书本
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
