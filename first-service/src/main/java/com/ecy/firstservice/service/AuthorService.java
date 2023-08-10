package com.ecy.firstservice.service;

import com.ecy.firstservice.dto.AuthorDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 9.08.2023
 * Time: 03:08
 */
public interface AuthorService {

    void create(AuthorDTO authorDTO);

    AuthorDTO get(Long id);

    List<AuthorDTO> getAll();

    List<AuthorDTO> getAll(Pageable pageable);

    List<AuthorDTO> getAll(String filter, String operation, String value, Integer page);

    void update(AuthorDTO authorDTO);

    void delete(Long id);

    void delete(AuthorDTO authorDTO);

    void deleteAll();

}