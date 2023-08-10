package com.ecy.firstservice.service.impl;

import com.ecy.firstservice.dto.BookDTO;
import com.ecy.firstservice.dto.mapper.BookMapper;
import com.ecy.firstservice.entities.Book;
import com.ecy.firstservice.repository.BookRepository;
import com.ecy.firstservice.service.BaseService;
import com.ecy.firstservice.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:57
 */

@Slf4j
@Service
public class BookServiceImpl extends BaseService<Book> implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           BookMapper bookMapper) {
        super(Book.class);
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    @Transactional
    public void create(BookDTO bookDTO) {
        bookRepository.save(bookMapper.mapToBook(bookDTO));
    }

    @Override
    @Transactional
    public BookDTO get(Long id) {
        try {
            return bookMapper.mapToBookDTO(bookRepository.getReferenceById(id));
        } catch (EntityNotFoundException exception) {
            log.error(exception.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public List<BookDTO> getAll() {
        return bookMapper.mapToBookDTOList(bookRepository.findAll());
    }

    @Override
    @Transactional
    public List<BookDTO> getAll(Pageable pageable) {
        return bookMapper.mapToBookDTOList(bookRepository.findAll(pageable).getContent());
    }

    @Override
    public List<BookDTO> getAll(String filter, String subFilter, String operation, String value, Integer page) {
        return bookMapper.mapToBookDTOList(search(filter, subFilter, operation, value, page));
    }

    @Override
    @Transactional
    public void update(BookDTO bookDTO) {
        bookRepository.save(bookMapper.mapToBook(bookDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(BookDTO bookDTO) {
        bookRepository.delete(bookMapper.mapToBook(bookDTO));
    }

    @Override
    @Transactional
    public void deleteAll() {
        bookRepository.deleteAll();
    }

}