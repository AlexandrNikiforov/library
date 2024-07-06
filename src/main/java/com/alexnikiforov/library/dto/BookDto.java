package com.alexnikiforov.library.dto;

import com.alexnikiforov.library.domain.AuthorEntity;
import com.alexnikiforov.library.domain.BookRating;
import com.alexnikiforov.library.domain.TableOfContent;
import lombok.Data;

import java.util.Set;

@Data
public class BookDto {
    private Long id;
    private String title;
    private Set<AuthorEntity> authors;
}
