package com.alexnikiforov.library.mappers;

import com.alexnikiforov.library.domain.AuthorEntity;
import com.alexnikiforov.library.dto.AuthorDto;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper {

    public AuthorEntity convertToEntity(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(authorDto.name());
        return authorEntity;
    }

    public AuthorDto convertToDto(AuthorEntity authorEntity) {
        return AuthorDto.builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .build();
    }
}
