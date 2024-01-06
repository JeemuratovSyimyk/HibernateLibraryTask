package org.example.Service;

import org.example.Entity.Publisher;

import java.util.List;

public interface PublisherService {
    String savePublisher(Publisher publisher);
    Publisher getPublisherById (Long id);
    List<Publisher> getAllPublishers(String ascOrDesc);
    void updatePublisher(Long id, Publisher publisher);
    void deletePublisherByName(String name);
}
