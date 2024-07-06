package com.alexnikiforov.library.services;

import com.alexnikiforov.library.domain.BookEntity;
import com.alexnikiforov.library.dto.BookDto;
import com.alexnikiforov.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = mapToEntity(bookDto);
        bookEntity = bookRepository.save(bookEntity);
        return mapToDto(bookEntity);
    }

    public BookDto getBookById(Long id) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        return optionalBookEntity.map(this::mapToDto).orElse(null);
    }

    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public BookDto updateBook(Long id, BookDto bookDto) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        if (optionalBookEntity.isPresent()) {
            BookEntity bookEntity = optionalBookEntity.get();
            bookEntity.setTitle(bookDto.getTitle());
            bookEntity.setAuthors(bookDto.getAuthors());
            bookEntity = bookRepository.save(bookEntity);
            return mapToDto(bookEntity);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDto mapToDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setAuthors(bookEntity.getAuthors());
        return bookDto;
    }

    private BookEntity mapToEntity(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthors(bookDto.getAuthors());
        return bookEntity;
    }
}
