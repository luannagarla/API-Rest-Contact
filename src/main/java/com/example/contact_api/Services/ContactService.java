package com.example.contact_api.Services;

import com.example.contact_api.Models.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> listar() {
        return contacts;
    }

    public Optional<Contact> buscar(int index) {
        if (index >= 0 && index < contacts.size()) {
            return Optional.of(contacts.get(index));
        } else {
            return Optional.empty();
        }
    }

    public Contact adicionar(Contact contact) {
        contact.setId(GenerateIndex());
        contacts.add(contact.getIndex(), contact);

        return contact;
    }

    public boolean remover(int index) {
        Optional<Contact> ctt = Optional.of(contacts.get(index));
        if(ctt == null)
            return false;

        contacts.remove(index);
        return true;
    }

    public Optional<Contact> atualizar(int index, Contact c) {
        if (index >= 0 && index < contacts.size()) {

            Contact existing = contacts.get(index);
            existing.setName(c.getName());
            existing.setEmail(c.getEmail());
            existing.setTelefone(c.getTelefone());
            return Optional.of(existing);
        } else {
            return Optional.empty();
        }
    }

    public int GenerateIndex()
    {
        if(contacts.size() == 0)
            return 0;

        return contacts.getLast().getIndex() + 1;
    }
}

