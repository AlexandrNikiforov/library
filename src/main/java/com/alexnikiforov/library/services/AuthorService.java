package com.alexnikiforov.library.services;

import com.alexnikiforov.library.domain.AuthorEntity;
import com.alexnikiforov.library.dto.AuthorDto;
import com.alexnikiforov.library.exceptions.SaveToDatabaseException;
import com.alexnikiforov.library.mappers.AuthorMapper;
import com.alexnikiforov.library.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorDto saveAuthor(AuthorDto authorDto) {
        try {
            if (authorDto == null) {
                throw new IllegalArgumentException("AuthorDto cannot be null");
            }

            AuthorEntity authorEntity = authorMapper.convertToEntity(authorDto);
            authorEntity = authorRepository.save(authorEntity);

            return authorMapper.convertToDto(authorEntity);
        } catch (Exception e) {
            log.error("Cannot save author");
            throw new SaveToDatabaseException("Failed to save author: ", e);
        }
    }

    public Set<AuthorEntity> saveAuthors(Set<AuthorDto> authorDtos) {
        Set<AuthorEntity> savedAuthors = new HashSet<>();
        for (AuthorDto authorDto : authorDtos) {
            AuthorEntity authorEntity = new AuthorEntity();
            authorEntity.setName(authorDto.getName());
            savedAuthors.add(authorEntity);
        }
        return new HashSet<>(authorRepository.saveAll(savedAuthors));
    }

}
