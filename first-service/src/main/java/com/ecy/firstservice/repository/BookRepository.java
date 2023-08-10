package com.ecy.firstservice.repository;

import com.ecy.firstservice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:55
 */

public interface BookRepository extends JpaRepository<Book, Long> {

}