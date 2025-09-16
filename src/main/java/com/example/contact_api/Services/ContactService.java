package com.example.contact_api.Services;

import com.example.contact_api.Models.Contact;
import com.example.contact_api.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listar() {
        return contactRepository.findAll();
    }

    public Optional<Contact> buscar(int id) {
        return contactRepository.findById(id);
    }

    public Contact adicionar(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> atualizar(int id, Contact c) {
        Optional<Contact> existing = contactRepository.findById(id);
        if (existing.isPresent()) {
            Contact contact = existing.get();
            contact.setNome(c.getNome());
            contact.setEmail(c.getEmail());
            contact.setTelefone(c.getTelefone());
            contact.setIdade(c.getIdade());
            contact.setDataNascimento(c.getDataNascimento());
            return Optional.of(contactRepository.save(contact));
        } else {
            return Optional.empty();
        }
    }

    public boolean remover(int id) {
        if (!contactRepository.existsById(id)) {
            return false;
        }
        contactRepository.deleteById(id);
        return true;
    }
}
