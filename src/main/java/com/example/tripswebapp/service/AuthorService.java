package com.example.tripswebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tripswebapp.model.Author;
import com.example.tripswebapp.model.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }
}
