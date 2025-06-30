package br.gov.sp.fatec.itu.projetocontatinhos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.projetocontatinhos.entities.Contato;
import br.gov.sp.fatec.itu.projetocontatinhos.services.contatoService;

@CrossOrigin
@RestController
@RequestMapping("contato")
public class ContatoController {

    @Autowired 
    private contatoService service;

    @GetMapping
    public ResponseEntity<List<Contato>> getContacts(
        @RequestParam(required = false) String search,
        @RequestParam(required = false) String category
    ) {
        if ((search == null || search.isEmpty()) && (category == null || category.isEmpty())) {
            return ResponseEntity.ok(service.getAll());
        } else {
            return ResponseEntity.ok(service.getFilteredContacts(search, category));
        }
    }


    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato) {
        return ResponseEntity.created(null).body(service.save(contato));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Contato contato) {
        service.update(contato, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContactFieldById(@PathVariable Long id) {
        return service.selectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/favorites")
    public ResponseEntity<List<Contato>> getFavoriteContacts() {
        List<Contato> favorites = service.getFavorite();
        return ResponseEntity.ok(favorites);
    }
}
