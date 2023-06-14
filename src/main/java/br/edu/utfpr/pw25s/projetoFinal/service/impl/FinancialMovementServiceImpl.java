package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement.FinancialMovementDTO;
import br.edu.utfpr.pw25s.projetoFinal.enums.MovementType;
import br.edu.utfpr.pw25s.projetoFinal.exceptions.FinancialMovementNegativeAmauntException;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import br.edu.utfpr.pw25s.projetoFinal.repository.FinancialMovementRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;
import br.edu.utfpr.pw25s.projetoFinal.service.FinancialMovementService;
import br.edu.utfpr.pw25s.projetoFinal.service.LoggedUserUtilsService;
import br.edu.utfpr.pw25s.projetoFinal.service.impl.AccountValueStrategy.AccountValueStrategy;
import br.edu.utfpr.pw25s.projetoFinal.service.impl.AccountValueStrategy.CreditAccountValueStrategy;
import br.edu.utfpr.pw25s.projetoFinal.service.impl.AccountValueStrategy.DebitAccountValueStrategy;
import br.edu.utfpr.pw25s.projetoFinal.service.impl.AccountValueStrategy.TransferAccountValueStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinancialMovementServiceImpl
        extends CrudServiceImpl<FinancialMovement, Long> implements FinancialMovementService {

    private static FinancialMovementRepository financialMovementRepository;

    private static AccountService accountService;

    private static ModelMapper modelMapper;

    private Map<MovementType, AccountValueStrategy> strategies = new HashMap<>();

    private static LoggedUserUtilsService loggedUserUtilsService;

    public FinancialMovementServiceImpl(FinancialMovementRepository financialMovementRepository,
        ModelMapper modelMapper, AccountService accountService, LoggedUserUtilsService loggedUserUtilsService) {

        this.financialMovementRepository = financialMovementRepository;
        this.accountService = accountService;
        this.modelMapper = modelMapper;
        this.loggedUserUtilsService = loggedUserUtilsService;

        strategies.put(MovementType.CREDIT, new CreditAccountValueStrategy(accountService));
        strategies.put(MovementType.DEBIT, new DebitAccountValueStrategy(accountService));
        strategies.put(MovementType.TRANSFER, new TransferAccountValueStrategy(accountService));
    }

    @Override
    protected JpaRepository<FinancialMovement, Long> getRepository() {
        return this.financialMovementRepository;
    }

    @Override
    public ResponseEntity<FinancialMovement> createMovement(FinancialMovementDTO financialMovementDTO) {
        FinancialMovement financialMovement = modelMapper.map(financialMovementDTO, FinancialMovement.class);

        AccountValueStrategy strategy = strategies.get(financialMovement.getType());

        try {
            strategy.execute(financialMovement);
        } catch (FinancialMovementNegativeAmauntException e) {
            throw new RuntimeException(e.getMessage());
        }

        this.save(financialMovement);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(financialMovement.getId()).toUri();

        return ResponseEntity.created(location).body(financialMovement);
    }

    @Override
    public List<FinancialMovement> findAll() {
        return this.financialMovementRepository.findAllByAccountUserUsername(
            loggedUserUtilsService.retornaObjetoDoUsuarioLogado().getUsername()
        );
    }

    public List<FinancialMovement> findAllByAccountId(Long id) {
        return this.financialMovementRepository.findAllByAccountId(id);
    }
}
