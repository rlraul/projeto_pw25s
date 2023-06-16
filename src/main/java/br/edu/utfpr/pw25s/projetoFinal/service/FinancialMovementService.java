package br.edu.utfpr.pw25s.projetoFinal.service;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FinancialMovementService extends CrudService<FinancialMovement, Long>{

    ResponseEntity<FinancialMovement> createMovement(FinancialMovementDTO financialMovementDTO);

    ResponseEntity<FinancialMovement> updateMovementSituation(Long id);

    List<FinancialMovement> findAllByAccountId(Long id);

}
