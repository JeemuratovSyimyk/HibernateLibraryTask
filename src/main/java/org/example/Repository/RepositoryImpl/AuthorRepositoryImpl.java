package org.example.Repository.RepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.example.Config.HibernateConfig;
import org.example.Entity.Author;
import org.example.Entity.Publisher;
import org.example.Repository.AuthorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorRepositoryImpl implements AuthorRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public Author saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public void updateAuthorById(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author author1 = entityManager.find(Author.class, id);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());
        author1.setCountry(author.getCountry());
        author1.setDate_of_birth(author.getDate_of_birth());
        author1.setGender(author.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public void assignAuthorToPublisher(Long publisherId, Long authorId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        Author author = entityManager.find(Author.class, authorId);

        List<Author> authors = publisher.getAuthors();
        authors.add(author);
        List<Publisher> publishers = author.getPublishers();
        publishers.add(publisher);

        author.setPublishers(publishers);
        publisher.setAuthors(authors);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Map<String, List<Author>> getAuthorsByPublisherId(Long publisherId) {
        Map<String, List<Author>> map = new HashMap<>();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        List<Author> authors = publisher.getAuthors();
        map.put(publisher.getName(), authors);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Author author = entityManager.find(Author.class, id);
            if (author != null) {
                entityManager.remove(author);
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().rollback();
                throw new EntityNotFoundException("Автор не найден по идентификатору: " + id);
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Ошибка удаления автора с идентификатором: " + id, e);
        }
    }
}