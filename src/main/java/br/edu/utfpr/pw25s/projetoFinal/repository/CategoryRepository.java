package br.edu.utfpr.pw25s.projetoFinal.repository;

import br.edu.utfpr.pw25s.projetoFinal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
