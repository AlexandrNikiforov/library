package com.alexnikiforov.library.mappers;

import com.alexnikiforov.library.domain.BookEntity;
import com.alexnikiforov.library.dto.AuthorDto;
import com.alexnikiforov.library.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookMapper {

    private final AuthorMapper authorMapper;

    public BookDto mapToDto(BookEntity bookEntity) {
        Set<AuthorDto> authorDtoSet = bookEntity.getAuthors()
                .stream()
                .map(authorMapper::convertToDto)
                .collect(Collectors.toSet());
        return BookDto.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .authors(authorDtoSet)
                .build();
    }
}
