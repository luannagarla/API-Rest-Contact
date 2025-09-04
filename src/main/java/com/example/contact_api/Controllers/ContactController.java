package com.example.contact_api.Controllers;

import com.example.contact_api.Models.Contact;
import com.example.contact_api.Services.ContactService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    //@Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> listar() {
        return contactService.listar();
    }

    @GetMapping("/{index}")
    public Contact buscar(@PathVariable int index) {
        return contactService.buscar(index);
    }

    @PostMapping
    public Contact adicionar(@RequestBody Contact contact) {
        return contactService.adicionar(contact);
    }

    @DeleteMapping("/{index}")
    public String remover(@PathVariable int index) {
        return contactService.remover(index);
    }

    @PutMapping("/{index}")
    public Contact atualizar(@PathVariable int index, @RequestBody Contact contact) {
        return contactService.atualizar(index, contact);
    }
}