package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;

  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  public void initData(){

    //Eric
    Author eric = new Author("Erik", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    //Rod
    Author rod = new Author("Rod", "Johanson");
    Book noEJB = new Book("J2EE Development without EJB", "23444","Worx");
    rod.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
}
