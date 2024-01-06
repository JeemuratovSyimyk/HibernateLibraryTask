package org.example.Service.ServiceImpl;

import org.example.Entity.Publisher;
import org.example.Repository.PublisherRepository;
import org.example.Repository.RepositoryImpl.PublisherRepositoryImpl;
import org.example.Service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
   PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    @Override
    public String savePublisher(Publisher publisher) {
        System.out.println(publisherRepository.savePublisher(publisher));
        return "Издатель с именем успешно сохранен. "+publisher.getName();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        return publisherRepository.getAllPublishers(ascOrDesc);
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
         publisherRepository.updatePublisher(id,publisher);
    }

    @Override
    public void deletePublisherByName(String name) {
     publisherRepository.deletePublisherByName(name);
    }
}
