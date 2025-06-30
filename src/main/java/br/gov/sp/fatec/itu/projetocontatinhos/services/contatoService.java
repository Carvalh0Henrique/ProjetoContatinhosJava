package br.gov.sp.fatec.itu.projetocontatinhos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.projetocontatinhos.entities.Contato;
import br.gov.sp.fatec.itu.projetocontatinhos.repositories.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class contatoService {
    @Autowired
    private ContatoRepository repository;

    public List<Contato> getAll() {
        return repository.findAll();
    }

    public Contato save(Contato contato) {
        return repository.save(contato);
    }

    public void update(Contato contato, long id) {
    Optional<Contato> optionalContato = repository.findById(id);

    if (optionalContato.isEmpty()) {
        throw new EntityNotFoundException("Contato com ID " + id + " não encontrado.");
    }

    Contato aux = optionalContato.get();
        
        aux.setName(contato.getName());
        aux.setLastName(contato.getLastName());
        aux.setNickname(contato.getNickname());
        aux.setPhone(contato.getPhone());
        aux.setEmail(contato.getEmail());
        aux.setDateBorn(contato.getDateBorn());
        aux.setAge(contato.getAge());
        aux.setGender(contato.getGender());
        aux.setCity(contato.getCity());
        aux.setArea(contato.getArea());
        aux.setCategory(contato.getCategory());
        aux.setFavorite(contato.getFavorite());

        repository.save(aux);
    }

    public void delete(long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Aluno não cadastrado.");
        }
    }

    public Optional<Contato> selectById(Long id) {
        return repository.findById(id);
    }

    
    public List<Contato> getFavorite() {
        return repository.findByFavorite(true);
    }

    public List<Contato> getFilteredContacts(String search, String category) {
        if ((search == null || search.isEmpty()) && (category == null || category.isEmpty())) {
            return repository.findAll();
        }

        return repository.findAll().stream()
            .filter(contato ->
                (search == null || contato.getName().toLowerCase().contains(search.toLowerCase()) ||
                contato.getLastName().toLowerCase().contains(search.toLowerCase()) ||
                contato.getEmail().toLowerCase().contains(search.toLowerCase()))
                &&
                (category == null || contato.getCategory().equalsIgnoreCase(category))
            )
            .collect(Collectors.toList());
    }
}
