package org.example.Service;

import org.example.Entity.Author;

import java.util.List;
import java.util.Map;

public interface AuthorService {
    Author saveAuthor(Author author);

    void updateAuthorById(Long id, Author author);

    Author getAuthorById(Long id);

    String assignAuthorToPublisher(Long publisherId, Long authorId);

    Map<String, List<Author>> getAuthorsByPublisherId(Long publisherId);

    void deleteAuthorById(Long id);
}
