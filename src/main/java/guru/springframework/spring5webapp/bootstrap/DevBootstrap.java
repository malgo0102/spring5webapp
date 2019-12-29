package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository,
                      BookRepository bookRepository,
                      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  public void initData(){

    //Eric
    Author eric = new Author("Erik", "Evans");
    Publisher hc = new Publisher("Harper Collins","address");
    Book ddd = new Book("Domain Driven Design", "1234", hc);

    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    ddd.setPublisher(hc);

    authorRepository.save(eric);
    publisherRepository.save(hc);
    bookRepository.save(ddd);


    //Rod
    Author rod = new Author("Rod", "Johanson");
    Publisher worx = new Publisher("Worx", "address");
    Book noEJB = new Book("J2EE Development without EJB", "23444",worx);

    rod.getBooks().add(noEJB);
    noEJB.setPublisher(worx);

    authorRepository.save(rod);
    publisherRepository.save(worx);
    bookRepository.save(noEJB);

  }
}
