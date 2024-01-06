package org.example;

import org.example.Config.HibernateConfig;
import org.example.Entity.Author;
import org.example.Entity.Publisher;
import org.example.Enum.Gender;
import org.example.Service.AuthorService;
import org.example.Service.BookService;
import org.example.Service.PublisherService;
import org.example.Service.ReaderService;
import org.example.Service.ServiceImpl.AuthorServiceImpl;
import org.example.Service.ServiceImpl.BookServiceImpl;
import org.example.Service.ServiceImpl.PublisherServiceImpl;
import org.example.Service.ServiceImpl.ReaderServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //   HibernateConfig.entityManagerFactory();

        Scanner scannerWord = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);
        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        while (true) {
            System.out.println("""
                    --------------------------------------------------------------------------------------------------------------------------------------------
                    ------------------------------------------------------------------------------------------------------------------------------------------||                            
                    ||                                     ---------------Choose operation---------------                                                      ||
                    ||         Publisher                       Author                            Book                              Reader                       ||
                    ||       1-save publisher                6-save author                    13-save book with author              20-save reader               ||
                    ||       2-get publisher by id        7-update author by id            14-updateBookAuthor                   21-update reader            ||
                    ||       3-getAllPublishersSort       8-getAuthorById                  15-assign publisher to book           22-deleteReaderById         ||
                    ||       4-update publisher           9-assign author to publisher     16-getBookAndPublisherByBookId        23-assign reader to book    ||
                    ||       5-deletePublisherByName      10-get authors by publisher id   17-deleteBookByAuthorId               24-getReaderByBookId        ||
                    ||                                    11-delete author by id                                                 25-getReadersByAuthorId     ||
                    --------------------------------------------------------------------------------------------------------------------------------------------
                    --------------------------------------------------------------------------------------------------------------------------------------------                              
                            """);
            switch (scannerNum.nextInt()) {
                case 1 -> System.out.println(publisherService.savePublisher(
                        new Publisher("Самоучитель кыргызского языка", "Баткен")));
                case 2 -> System.out.println(publisherService.getPublisherById(1L));
                case 3 -> System.out.println(publisherService.getAllPublishers("с"));
                case 4 -> publisherService.updatePublisher(1L, new Publisher("Самоучитель кыргызского языка", "Бишкек"));
                case 5 -> publisherService.deletePublisherByName("Самоучитель кыргызского языка");

                case 6 -> authorService.saveAuthor(new Author("Тугельбая","Сыдыкбекова","Т@gmail.com", LocalDate.of(1987,3,5), "Кыргызстан", Gender.FEMALE));
                case 7 -> authorService.updateAuthorById(3L,new Author("Аалы","Токомбаев","A@gmail.ru",LocalDate.of(1978,4,6),"Кыргызстан",Gender.MALE));
                case 8 -> System.out.println(authorService.getAuthorById(2L));
                case 9 -> System.out.println(authorService.assignAuthorToPublisher(2L,2L));
                case 10 -> System.out.println(authorService.getAuthorsByPublisherId(3L));
                case 11 -> authorService.deleteAuthorById(3L);
            }





        }
    }
}
