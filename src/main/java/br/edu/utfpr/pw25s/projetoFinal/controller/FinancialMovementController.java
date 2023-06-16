package br.edu.utfpr.pw25s.projetoFinal.controller;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import br.edu.utfpr.pw25s.projetoFinal.service.FinancialMovementService;
import br.edu.utfpr.pw25s.projetoFinal.shared.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movements")
public class FinancialMovementController {

    private static FinancialMovementService financialMovementService;

    public FinancialMovementController(FinancialMovementService financialMovementService) {
        this.financialMovementService = financialMovementService;
    }

    @PostMapping()
    public ResponseEntity<FinancialMovementDTO> createMovement(@Valid @RequestBody FinancialMovementDTO financialMovementDTO) {
        this.financialMovementService.createMovement(financialMovementDTO);
        return ResponseEntity.ok(financialMovementDTO);
    }

    @PostMapping("{id}")
    public ResponseEntity<HttpStatus> updateMovementSituation(@PathVariable Long id) {
        this.financialMovementService.updateMovementSituation(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public List<FinancialMovement> findAll() {
        return this.financialMovementService.findAll();
    }

    @GetMapping("/account/{id}")
    public List<FinancialMovement> findAll(@PathVariable Long id) {
        return this.financialMovementService.findAllByAccountId(id);
    }

    @DeleteMapping("{id}")
    public GenericResponse cancelMovement(@PathVariable Long id) {
        return this.financialMovementService.cancelMovement(id);
    }
}
