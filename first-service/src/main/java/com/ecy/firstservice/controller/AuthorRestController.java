package com.ecy.firstservice.controller;

import com.ecy.firstservice.dto.AuthorDTO;
import com.ecy.firstservice.service.AuthorService;
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
 * Date: 9.08.2023
 * Time: 03:07
 */

@RestController
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.create(authorDTO);
    }

    @PutMapping("/author")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.update(authorDTO);
    }

    @GetMapping("/author")
    public ResponseEntity<AuthorDTO> get(@RequestParam Long id) {
        var author = authorService.get(id);
        return author != null ?
                ResponseEntity.ok(author) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDTO>> getAll(@RequestParam Optional<Integer> page,
                                                  @RequestParam(defaultValue = "2") Integer size,
                                                  @RequestParam Optional<String> sort,
                                                  @RequestParam(defaultValue = "asc") String order) {
        var authors = page.isPresent() ?
                sort.isPresent() ?
                        authorService.getAll(PageRequest.of(page.get(), size, Sort.by(Sort.Direction.fromString(order), sort.get()))) :
                        authorService.getAll(PageRequest.of(page.get(), size)) :
                authorService.getAll();
        return !authors.isEmpty() ?
                ResponseEntity.ok(authors) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/authors/search")
    public ResponseEntity<List<AuthorDTO>> getAll(@RequestParam String filter,
                                                  @RequestParam String operation,
                                                  @RequestParam String value,
                                                  @RequestParam Optional<Integer> page) {
        var authors = authorService.getAll(filter, operation, value, page.orElse(null));
        return !authors.isEmpty() ?
                ResponseEntity.ok(authors) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long id) {
        authorService.delete(id);
    }

    @DeleteMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        authorService.deleteAll();
    }

}