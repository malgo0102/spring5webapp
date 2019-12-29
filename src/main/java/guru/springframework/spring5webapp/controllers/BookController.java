package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//Spring bean which is
@Controller
public class BookController {
  //Model is an interface, Spring is passing an implementation of model at runtime

  private BookRepository bookRepository;

  public BookController(BookRepository bookRepository){
    this.bookRepository = bookRepository;
  }

  @RequestMapping("/books")
  public String getBooks(Model model){
    model.addAttribute("books", bookRepository.findAll());

    return "books";
  }
}
