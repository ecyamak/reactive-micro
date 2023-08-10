package com.ecy.firstservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:52
 */

@Getter
@Setter
public class BookDTO {

    private Long id;

    @NotBlank(message = "Book title is required!")
    private String title;

    @NotNull(message = "Author is required!")
    private AuthorDTO author;

}