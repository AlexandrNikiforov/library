package com.alexnikiforov.library.controllers;

import com.alexnikiforov.library.dto.AuthorDto;
import com.alexnikiforov.library.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto savedAuthorDto = authorService.saveAuthor(authorDto);
        return ResponseEntity.ok(savedAuthorDto);
    }

}
