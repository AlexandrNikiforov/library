package com.alexnikiforov.library.services;

import com.alexnikiforov.library.domain.AuthorEntity;
import com.alexnikiforov.library.domain.BookEntity;
import com.alexnikiforov.library.dto.AuthorDto;
import com.alexnikiforov.library.dto.BookDto;
import com.alexnikiforov.library.exceptions.AuthorNotFoundException;
import com.alexnikiforov.library.mappers.AuthorMapper;
import com.alexnikiforov.library.mappers.BookMapper;
import com.alexnikiforov.library.repositories.AuthorRepository;
import com.alexnikiforov.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDto.title());

        Set<AuthorDto> authorDtoSet = bookDto.authors();
        Set<AuthorEntity> authorEntitiesSet = new HashSet<>();
        if (authorDtoSet != null) {
            for (AuthorDto author : authorDtoSet) {
                Optional<AuthorEntity> authorEntityOptional = authorRepository.findByName(author.name());
                authorEntityOptional.orElseThrow(() -> new AuthorNotFoundException("Author not found. Create an author first"));
                authorEntityOptional
                        .ifPresent((authorEntitiesSet::add));
            }
            bookEntity.setAuthors(authorEntitiesSet);
        }
        bookEntity = bookRepository.save(bookEntity);

        return bookMapper.mapToDto(bookEntity);
    }

    public BookDto getBookById(Long id) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        return optionalBookEntity.map(bookMapper::mapToDto).orElse(null);
    }

    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
