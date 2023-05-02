package br.edu.utfpr.pw25s.projetoFinal.service.impl.AccountValueStrategy;

import br.edu.utfpr.pw25s.projetoFinal.exceptions.FinancialMovementNegativeAmauntException;
import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;
import org.modelmapper.ModelMapper;

public class TransferAccountValueStrategy implements AccountValueStrategy {

    private static AccountService accountService;

    public TransferAccountValueStrategy(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(FinancialMovement financialMovement) throws FinancialMovementNegativeAmauntException {
        Account account = accountService.findById(financialMovement.getAccount().getId()).get();
        Account accountToTransfer = accountService.findById(financialMovement.getAccountToTransfer().getId()).get();

        if (financialMovement.getValue().compareTo(account.getAmount()) == 1) {
            throw new FinancialMovementNegativeAmauntException("Saldo insuficiente para a transferencia!");
        }

        account.setAmount(account.getAmount().subtract(financialMovement.getValue()));
        accountToTransfer.setAmount(accountToTransfer.getAmount().add(financialMovement.getValue()));

        accountService.save(account);
        accountService.save(accountToTransfer);

    }
}
