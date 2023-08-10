package com.ecy.firstservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:53
 */

@Getter
@Setter
public class AuthorDTO {

    private Long id;

    @NotBlank(message = "Author name is required!")
    private String name;

}