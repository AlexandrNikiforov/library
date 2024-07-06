package com.alexnikiforov.library.services;

import com.alexnikiforov.library.domain.AuthorEntity;
import com.alexnikiforov.library.dto.AuthorDto;
import com.alexnikiforov.library.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Set<AuthorEntity> saveAuthors(Set<AuthorDto> authorDtos) {
        Set<AuthorEntity> savedAuthors = new HashSet<>();
        for (AuthorDto authorDto : authorDtos) {
            AuthorEntity authorEntity = new AuthorEntity();
            authorEntity.setName(authorDto.getName());
            savedAuthors.add(authorEntity);
        }
        return new HashSet<>(authorRepository.saveAll(savedAuthors));
    }

    public AuthorEntity convertToEntity(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(authorDto.getName());
        return authorEntity;
    }

    public AuthorDto convertToDto(AuthorEntity authorEntity) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorEntity.getId());
        authorDto.setName(authorEntity.getName());
        return authorDto;
    }
}
