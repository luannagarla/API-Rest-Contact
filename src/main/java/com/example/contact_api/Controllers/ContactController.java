package com.example.contact_api.Controllers;

import com.example.contact_api.Models.Contact;
import com.example.contact_api.Services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    //@Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> listar() {
        List<Contact> contatos = contactService.listar();
        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Optional<Contact>> buscar(@PathVariable int index) {
        try
        {
            Optional<Contact> contact = contactService.buscar(index);
            if (contact != null) {
                return ResponseEntity.ok(contact);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Contact> adicionar(@RequestBody Contact contact) {
        Contact criado = contactService.adicionar(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> remover(@PathVariable int index) {

        try
        {
            boolean removed = contactService.remover(index);
            if (removed) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Contado removido com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }
    }

    @PutMapping("/{index}")
    public ResponseEntity<Optional<Contact>> atualizar(@PathVariable int index, @RequestBody Contact contact) {

        try
        {
            Optional<Contact> atualizado = contactService.atualizar(index, contact);

            if (atualizado != null) {
                return ResponseEntity.ok(atualizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}