package br.edu.utfpr.pw25s.projetoFinal.service;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.enums.MovementType;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import br.edu.utfpr.pw25s.projetoFinal.shared.GenericResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FinancialMovementService extends CrudService<FinancialMovement, Long>{

    ResponseEntity<FinancialMovement> createMovement(FinancialMovementDTO financialMovementDTO);

    GenericResponse updateMovementSituation(Long id);

    GenericResponse cancelMovement(Long id);

    List<FinancialMovement> findAllByAccountId(Long id);

    Page<FinancialMovement> findAllByAccountUserUsernameAndTypeOrderByDateDesc(MovementType type, int page, int size);

    void executeMovementTypeStrategy(FinancialMovement financialMovement);

}
