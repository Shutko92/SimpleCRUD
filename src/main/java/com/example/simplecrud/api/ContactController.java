package com.example.simplecrud.api;

import com.example.simplecrud.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public interface ContactController {

    @GetMapping("/")
    String index(Model model);

    @GetMapping("/contact/create")
    String showCreateForm(Model model);

    @PostMapping("/contact/create")
    String createContact(@ModelAttribute Contact contact);

    @GetMapping("/contact/edit/{id}")
    String showEditForm(@PathVariable Long id, Model model);

    @PostMapping("/contact/ edit")
    String editContact(@ModelAttribute Contact contact);

    @GetMapping("contact/delete/{id}")
    String deleteContact(@PathVariable Long id);
}
