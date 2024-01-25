package com.example.simplecrud.impl;

import com.example.simplecrud.api.ContactService;
import com.example.simplecrud.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contacts", service.findAll());
        return "index";
    }

    @GetMapping("/contact/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "create";
    }

    @PostMapping("/contact/create")
    public String createContact(@ModelAttribute Contact contact) {
        service.save(contact);
        return "redirect:/";
    }

    @GetMapping("/contact/modify/{id}")
    public String showModifyForm(@PathVariable Long id, Model model) {
        Contact contact = service.findById(id);
        if (contact != null) {
            model.addAttribute("contact", contact);
            return "modify";
        }
        return "redirect:/";
    }

    @PostMapping("/contact/modify")
    public String modifyContact(@ModelAttribute Contact contact) {
        service.modify(contact);
        return "redirect:/";
    }

    @GetMapping("contact/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
