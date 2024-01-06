package org.example.Service;

import org.example.Entity.Reader;

import java.util.List;

public interface ReaderService {
    void saveReader(Reader reader);

    void updateReaderById(Long id, Reader reader);

    Reader getReaderByBookId(Long id);

    void deleteReaderById(Long id);

    void assignReaderToBook(Long readerId, Long bookId);

    List<Reader> getReadersByAuthorId(Long authorId);
}
