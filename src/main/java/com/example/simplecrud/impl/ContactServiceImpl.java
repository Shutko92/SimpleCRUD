package com.example.simplecrud.impl;

import com.example.simplecrud.api.ContactService;
import com.example.simplecrud.model.Contact;
import com.example.simplecrud.repo.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        Contact existing = contactRepository.findById(contact.getId()).get();
        existing.setFirstName(contact.getFirstName());
        existing.setLastName(contact.getLastName());
        existing.setPhone(contact.getPhone());
        existing.setEmail(contact.getEmail());
        return contactRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
