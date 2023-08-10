package com.ecy.firstservice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:42
 */

@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "book", indexes = @Index(name = "author_idx", columnList = "author_id"))
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "fk_author_id"), nullable = false)
    private Author author;

}