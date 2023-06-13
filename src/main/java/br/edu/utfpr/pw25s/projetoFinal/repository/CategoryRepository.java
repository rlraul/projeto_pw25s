package br.edu.utfpr.pw25s.projetoFinal.repository;

import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserUsername(String username);

}
