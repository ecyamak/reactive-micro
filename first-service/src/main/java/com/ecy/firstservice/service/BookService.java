package com.ecy.firstservice.service;

import com.ecy.firstservice.dto.BookDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:57
 */

public interface BookService {

    void create(BookDTO bookDTO);

    BookDTO get(Long id);

    List<BookDTO> getAll();

    List<BookDTO> getAll(Pageable pageable);

    List<BookDTO> getAll(String filter, String subfilter, String operation, String value, Integer page);

    void update(BookDTO bookDTO);

    void delete(Long id);

    void delete(BookDTO bookDTO);

    void deleteAll();

}