package org.example.Service.ServiceImpl;

import org.example.Entity.Reader;
import org.example.Service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {

    }

    @Override
    public void updateReaderById(Long id, Reader reader) {

    }

    @Override
    public Reader getReaderByBookId(Long id) {
        return null;
    }

    @Override
    public void deleteReaderById(Long id) {

    }

    @Override
    public void assignReaderToBook(Long readerId, Long bookId) {

    }

    @Override
    public List<Reader> getReadersByAuthorId(Long authorId) {
        return null;
    }
}
