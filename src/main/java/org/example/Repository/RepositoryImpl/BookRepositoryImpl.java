package org.example.Repository.RepositoryImpl;

import org.example.Entity.Book;
import org.example.Entity.Publisher;
import org.example.Repository.BookRepository;

import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public  void updateBookAuthor(Long id, Book book) {

    }

    @Override
    public void saveBookWithAuthor(Book book, Long authorId) {

    }

    @Override
    public void deleteBookByAuthorId(Long id) {

    }

    @Override
    public void assignPublisherToBook(Long bookId, Long publisherId) {

    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        return null;
    }
}
