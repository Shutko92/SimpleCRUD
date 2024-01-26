package com.example.simplecrud.service;

import com.example.simplecrud.model.Contact;
import com.example.simplecrud.repo.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact modify(Contact contact) {
        Contact existing = contactRepository.findById(contact.getId()).get();
        existing.setFirstName(contact.getFirstName());
        existing.setLastName(contact.getLastName());
        existing.setPhone(contact.getPhone());
        existing.setEmail(contact.getEmail());
        return contactRepository.save(existing);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
