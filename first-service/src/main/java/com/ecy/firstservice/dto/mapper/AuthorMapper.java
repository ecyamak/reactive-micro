package com.ecy.firstservice.dto.mapper;

import com.ecy.firstservice.dto.AuthorDTO;
import com.ecy.firstservice.entities.Author;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 9.08.2023
 * Time: 00:07
 */

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO mapToAuthorDTO(Author author);

    List<AuthorDTO> mapToAuthorDTOList(List<Author> authors);

    Author mapToAuthor(AuthorDTO authorDTO);

}