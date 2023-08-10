package com.ecy.firstservice.repository;

import com.ecy.firstservice.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:56
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

}