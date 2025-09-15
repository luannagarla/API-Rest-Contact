package com.example.contact_api.controllers;

import com.example.contact_api.models.Contact;
import com.example.contact_api.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> listar() {
        List<Contact> contatos = contactService.listar();
        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> buscar(@PathVariable int id) {
        Optional<Contact> contact = contactService.buscar(id);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Contact> adicionar(@Valid @RequestBody Contact contact) {
        Contact criado = contactService.adicionar(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable int id) {
        boolean removed = contactService.remover(id);
        if (removed) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Contato removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> atualizar(@PathVariable int id, @Valid @RequestBody Contact contact) {
        Optional<Contact> atualizado = contactService.atualizar(id, contact);
        return atualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
