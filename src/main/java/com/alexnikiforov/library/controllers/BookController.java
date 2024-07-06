package com.alexnikiforov.library.controllers;

import com.alexnikiforov.library.dto.BookDto;
import com.alexnikiforov.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return bookService.updateBook(id, bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
