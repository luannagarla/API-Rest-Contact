package com.example.contact_api.Services;

import com.example.contact_api.Models.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> listar() {
        return contacts;
    }

    public Contact buscar(int index) {
        return contacts.get(index);
    }

    public Contact adicionar(Contact contact) {
        contacts.add(contact);

        return contact;
    }

    public String remover(int index) {
        contacts.remove(index);

        return "Contato removido com sucesso!";
    }

    public Contact atualizar (int index, Contact c){
        Contact ctt = contacts.get(index);

        ctt.setId(index);
        ctt.setName(c.getName());
        ctt.setEmail(c.getEmail());
        ctt.setTelefone(c.getTelefone());

        return ctt;
    }
}

