package org.example.Repository;

import org.example.Entity.Author;

import java.util.List;
import java.util.Map;

public interface AuthorRepository {
    Author saveAuthor(Author author);

    void updateAuthorById(Long id, Author author);

    Author getAuthorById(Long id);

    void assignAuthorToPublisher(Long publisherId,Long authorId);

    Map<String, List<Author>> getAuthorsByPublisherId(Long publisherId);

    void deleteAuthorById(Long id);
}
