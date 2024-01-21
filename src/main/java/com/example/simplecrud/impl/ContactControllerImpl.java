package com.example.simplecrud.impl;

import com.example.simplecrud.api.ContactController;
import com.example.simplecrud.api.ContactService;
import com.example.simplecrud.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class ContactControllerImpl implements ContactController {
    private final ContactService service;

    @Override
    public String index(Model model) {
        model.addAttribute("contacts", service.findAll());
        return "index";
    }

    @Override
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "create";
    }

    @Override
    public String createContact(Contact contact) {
        service.save(contact);
        return "redirect:/";
    }

    @Override
    public String showEditForm(Long id, Model model) {
        Contact contact = service.findById(id);
        if (contact != null) {
            model.addAttribute("contact", contact);
            return "edit";
        }
        return "redirect:/";
    }

    @Override
    public String editContact(Contact contact) {
        service.update(contact);
        return "redirect:/";
    }

    @Override
    public String deleteContact(Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
