package com.example.tripswebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.tripswebapp.model.Author;
import com.example.tripswebapp.service.AuthorService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/authors")

public class AuthorsController {

    @Autowired
    AuthorService authorService;

    @GetMapping("")
    public ModelAndView getAllAuthors() {
        ModelAndView mv = new ModelAndView("authors");
        mv.addObject("authors", authorService.getAllAuthors());
        return mv;
    }

    @GetMapping(path = "/add")
    public String showAddAuthorPage(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping(path = "/add")
    public String saveNewAuthor(@Valid Author author, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "add-author";
        }
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
}