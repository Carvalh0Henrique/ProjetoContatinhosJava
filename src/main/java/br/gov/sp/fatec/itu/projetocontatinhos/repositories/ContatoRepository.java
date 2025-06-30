package br.gov.sp.fatec.itu.projetocontatinhos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.itu.projetocontatinhos.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByFavorite(boolean favorite);

    @Query("SELECT c FROM Contato c " +
       "WHERE (:search IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
       "   OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
       "   OR LOWER(c.email) LIKE LOWER(CONCAT('%', :search, '%')) " +
       "   OR LOWER(c.phone) LIKE LOWER(CONCAT('%', :search, '%'))) " +
       "AND (:category IS NULL OR c.category = :category)")
    List<Contato> findBySearchAndCategory(@Param("search") String search, @Param("category") String category);

}
