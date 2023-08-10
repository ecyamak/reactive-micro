package com.ecy.firstservice.dto.mapper;

import com.ecy.firstservice.dto.BookDTO;
import com.ecy.firstservice.entities.Book;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Author: ecyamak
 * Date: 9.08.2023
 * Time: 00:09
 */

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO mapToBookDTO(Book book);

    List<BookDTO> mapToBookDTOList(List<Book> books);

    Book mapToBook(BookDTO bookDTO);

}