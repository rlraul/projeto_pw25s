package br.edu.utfpr.pw25s.projetoFinal.service.impl.AccountValueStrategy;

import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.model.FinancialMovement;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;

public class DebitAccountValueStrategy implements AccountValueStrategy {

    private static AccountService accountService;

    public DebitAccountValueStrategy(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(FinancialMovement financialMovement) {
        Account account = accountService.findById(financialMovement.getAccount().getId()).get();
        account.setAmount(account.getAmount().subtract(financialMovement.getValue()));
        accountService.save(account);
    }
}
