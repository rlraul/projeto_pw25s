package br.edu.utfpr.pw25s.projetoFinal.service;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import org.springframework.http.ResponseEntity;

public interface FinancialMovementService extends CrudService<FinancialMovement, Long>{

    ResponseEntity<FinancialMovement> createMovement(FinancialMovementDTO financialMovementDTO);

}
