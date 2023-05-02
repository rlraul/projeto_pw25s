package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import br.edu.utfpr.pw25s.projetoFinal.repository.AccountRepository;
import br.edu.utfpr.pw25s.projetoFinal.repository.FinancialMovementRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;
import br.edu.utfpr.pw25s.projetoFinal.service.FinancialMovementService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class FinancialMovementServiceImpl
        extends CrudServiceImpl<FinancialMovement, Long> implements FinancialMovementService {

    private static FinancialMovementRepository financialMovementRepository;

    private static AccountService accountService;

    private static ModelMapper modelMapper;

    public FinancialMovementServiceImpl(FinancialMovementRepository financialMovementRepository,
                                        ModelMapper modelMapper, AccountService accountService) {
        this.financialMovementRepository = financialMovementRepository;
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected JpaRepository<FinancialMovement, Long> getRepository() {
        return this.financialMovementRepository;
    }

    @Override
    public ResponseEntity<FinancialMovement> createMovement(FinancialMovementDTO financialMovementDTO) {
        FinancialMovement financialMovement = modelMapper.map(financialMovementDTO, FinancialMovement.class);

        switch (financialMovement.getType()) {
            case CREDIT: creditAccountValue(financialMovement);
            case DEBIT: debitAccountValue(financialMovement);
            //case TRANSFER: transferAccountValue(financialMovement);
        }

        this.save(financialMovement);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(financialMovement.getId()).toUri();

        return ResponseEntity.created(location).body(financialMovement);
    }

    private void creditAccountValue(FinancialMovement financialMovement) {
        Account account = accountService.findById(financialMovement.getAccount().getId()).get();
        account.setAmount(account.getAmount().add(financialMovement.getValue()));
        accountService.save(account);
    }

    private void debitAccountValue(FinancialMovement financialMovement) {
        Account account = accountService.findById(financialMovement.getAccount().getId()).get();
        account.setAmount(account.getAmount().subtract(financialMovement.getValue()));
        accountService.save(account);
    }

}
