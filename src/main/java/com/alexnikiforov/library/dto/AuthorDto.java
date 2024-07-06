package com.alexnikiforov.library.dto;

import lombok.Builder;

@Builder
public record AuthorDto(
        Long id,
        String name
) {}
