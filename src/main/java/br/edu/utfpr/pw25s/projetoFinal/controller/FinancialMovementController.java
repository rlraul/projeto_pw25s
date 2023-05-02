package br.edu.utfpr.pw25s.projetoFinal.controller;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.service.FinancialMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("movements")
public class FinancialMovementController {

    private static FinancialMovementService financialMovementService;

    public FinancialMovementController(FinancialMovementService financialMovementService) {
        this.financialMovementService = financialMovementService;
    }

    @PostMapping("credit")
    public ResponseEntity<FinancialMovementDTO> createMovement(@Valid @RequestBody FinancialMovementDTO financialMovementDTO) {
        this.financialMovementService.createMovement(financialMovementDTO);
        return ResponseEntity.ok(financialMovementDTO);
    }
}
