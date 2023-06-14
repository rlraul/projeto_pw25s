package br.edu.utfpr.pw25s.projetoFinal.repository;

import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialMovementRepository extends JpaRepository<FinancialMovement, Long> {

    List<FinancialMovement> findAllByAccountUserUsername(String username);

    List<FinancialMovement> findAllByAccountId(Long id);

}
