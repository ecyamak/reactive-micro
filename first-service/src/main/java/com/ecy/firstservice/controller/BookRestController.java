package com.ecy.firstservice.controller;

import com.ecy.firstservice.dto.BookDTO;
import com.ecy.firstservice.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 23:54
 */

@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody BookDTO bookDTO) {
        bookService.create(bookDTO);
    }

    @PutMapping("/book")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@Valid @RequestBody BookDTO bookDTO) {
        bookService.update(bookDTO);
    }

    @GetMapping("/book")
    public ResponseEntity<BookDTO> get(@RequestParam Long id) {
        var book = bookService.get(id);
        return book != null ?
                ResponseEntity.ok(book) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAll(@RequestParam Optional<Integer> page,
                                                @RequestParam(defaultValue = "2") Integer size,
                                                @RequestParam Optional<String> sort,
                                                @RequestParam(defaultValue = "asc") String order) {
        var books = page.isPresent() ?
                sort.isPresent() ?
                        bookService.getAll(PageRequest.of(page.get(), size, Sort.by(Sort.Direction.fromString(order), sort.get()))) :
                        bookService.getAll(PageRequest.of(page.get(), size)) :
                bookService.getAll();
        return !books.isEmpty() ?
                ResponseEntity.ok(books) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/search")
    public ResponseEntity<List<BookDTO>> getAll(@RequestParam String filter,
                                                @RequestParam Optional<String> subFilter,
                                                @RequestParam String operation,
                                                @RequestParam String value,
                                                @RequestParam Optional<Integer> page) {
        var books = bookService.getAll(filter, subFilter.orElse(null), operation, value, page.orElse(null));
        return !books.isEmpty() ?
                ResponseEntity.ok(books) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long id) {
        bookService.delete(id);
    }

    @DeleteMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        bookService.deleteAll();
    }

}