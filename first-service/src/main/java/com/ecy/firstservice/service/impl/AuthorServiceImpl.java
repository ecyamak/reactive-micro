package com.ecy.firstservice.service.impl;

import com.ecy.firstservice.dto.AuthorDTO;
import com.ecy.firstservice.entities.Author;
import com.ecy.firstservice.repository.AuthorRepository;
import com.ecy.firstservice.service.AuthorService;
import com.ecy.firstservice.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository,
                             ModelMapper modelMapper) {
        super(Author.class);
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void create(AuthorDTO authorDTO) {
        authorRepository.save(modelMapper.map(authorDTO, Author.class));
    }

    @Override
    @Transactional
    public AuthorDTO get(Long id) {
        try {
            return modelMapper.map(authorRepository.getReferenceById(id), AuthorDTO.class);
        } catch (EntityNotFoundException exception) {
            log.error(exception.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .toList();
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable).getContent().stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .toList();
    }

    @Override
    @Transactional
    public List<AuthorDTO> getAll(String filter, String operation, String value, Integer page) {
        return search(filter, null, operation, value, page).stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .toList();
    }

    @Override
    @Transactional
    public void update(AuthorDTO authorDTO) {
        authorRepository.save(modelMapper.map(authorDTO, Author.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(AuthorDTO authorDTO) {
        authorRepository.delete(modelMapper.map(authorDTO, Author.class));
    }

    @Override
    @Transactional
    public void deleteAll() {
        authorRepository.deleteAll();
    }

}