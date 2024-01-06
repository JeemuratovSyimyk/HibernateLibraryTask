package org.example.Service;

import org.example.Entity.Book;
import org.example.Entity.Publisher;

import java.util.Map;

public interface BookService {
    void updateBookAuthor(Long id, Book book);

    void saveBookWithAuthor(Book book,Long authorId);

    void deleteBookByAuthorId(Long id);

    void assignPublisherToBook(Long bookId, Long publisherId);

    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId);
}
