package com.ecy.firstservice.service.impl;

import com.ecy.firstservice.dto.AuthorDTO;
import com.ecy.firstservice.dto.mapper.AuthorMapper;
import com.ecy.firstservice.entities.Author;
import com.ecy.firstservice.repository.AuthorRepository;
import com.ecy.firstservice.service.AuthorService;
import com.ecy.firstservice.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 9.08.2023
 * Time: 03:08
 */

@Slf4j
@Service
public class AuthorServiceImpl extends BaseService<Author> implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository,
                             AuthorMapper authorMapper) {
        super(Author.class);
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    @Transactional
    public void create(AuthorDTO authorDTO) {
        authorRepository.save(authorMapper.mapToAuthor(authorDTO));
    }

    @Override
    @Transactional
    public AuthorDTO get(Long id) {
        try {
            return authorMapper.mapToAuthorDTO(authorRepository.getReferenceById(id));
        } catch (EntityNotFoundException exception) {
            log.error(exception.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll() {
        return authorMapper.mapToAuthorDTOList(authorRepository.findAll());
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll(Pageable pageable) {
        return authorMapper.mapToAuthorDTOList(authorRepository.findAll(pageable).getContent());
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll(String filter, String operation, String value, Integer page) {
        return authorMapper.mapToAuthorDTOList(search(filter, null, operation, value, page));
    }

    @Override
    @Transactional
    public void update(AuthorDTO authorDTO) {
        authorRepository.save(authorMapper.mapToAuthor(authorDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(AuthorDTO authorDTO) {
        authorRepository.delete(authorMapper.mapToAuthor(authorDTO));
    }

    @Override
    @Transactional
    public void deleteAll() {
        authorRepository.deleteAll();
    }

}