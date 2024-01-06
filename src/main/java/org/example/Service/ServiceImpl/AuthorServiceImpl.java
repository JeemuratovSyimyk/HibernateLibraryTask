package org.example.Service.ServiceImpl;

import org.example.Entity.Author;
import org.example.Repository.AuthorRepository;
import org.example.Repository.RepositoryImpl.AuthorRepositoryImpl;
import org.example.Service.AuthorService;

import java.util.List;
import java.util.Map;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository = new AuthorRepositoryImpl();
    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public void updateAuthorById(Long id, Author author) {
     authorRepository.updateAuthorById(id,author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public String assignAuthorToPublisher(Long publisherId, Long authorId) {
   authorRepository.assignAuthorToPublisher(publisherId,authorId);
        return "Successfully assigned author to publisher!";
    }

    @Override
    public Map<String, List<Author>> getAuthorsByPublisherId(Long publisherId) {
        return authorRepository.getAuthorsByPublisherId(publisherId);
    }

    @Override
    public void deleteAuthorById(Long id) {
      authorRepository.deleteAuthorById(id);
    }
}
