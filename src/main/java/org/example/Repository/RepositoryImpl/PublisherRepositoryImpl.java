package org.example.Repository.RepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.Config.HibernateConfig;
import org.example.Entity.Publisher;
import org.example.Repository.PublisherRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {

    private final EntityManager entityManager  = HibernateConfig.getEntityManager();

    @Override
    public Publisher savePublisher(Publisher publisher) {
     entityManager.getTransaction().begin();
        Publisher publisher1 = new Publisher();
        publisher1.setName(publisher.getName());
        publisher1.setAddress(publisher.getAddress());
        entityManager.persist(publisher1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher1;
    }

    @Override
    public Publisher getPublisherById(Long id) {
      entityManager.getTransaction().begin();
     Publisher publisher = entityManager.find(Publisher.class,id);
     entityManager.getTransaction().commit();
     entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        entityManager.getTransaction().begin();
        List<Publisher> publishers = entityManager.createQuery("""
          select p from Publisher p order by name
         """ + ascOrDesc,Publisher.class).getResultList();
     entityManager.getTransaction().commit();
     entityManager.close();
        return publishers;
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        Publisher publisher1 = entityManager.find(Publisher.class,id);
        publisher1.setName(publisher.getName());
        publisher1.setAddress(publisher.getAddress());
        entityManager.persist(publisher1);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deletePublisherByName(String name) {
     entityManager.getTransaction().begin();
     Publisher publisher = entityManager.createQuery("""
       select p from Publisher p where name ilike ?1
       """,Publisher.class).setParameter(1, name + '%').getSingleResult();
             entityManager.remove(publisher);
             entityManager.getTransaction().commit();
             entityManager.close();
    }
}
