package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.repository.AccountRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends CrudServiceImpl<Account, Long> implements AccountService {

    private static AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    protected JpaRepository<Account, Long> getRepository() {
        return this.accountRepository;
    }

}
