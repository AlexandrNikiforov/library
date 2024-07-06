package com.alexnikiforov.library.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record BookDto(
        Long id,
        String title,
        Set<AuthorDto> authors
) {}
