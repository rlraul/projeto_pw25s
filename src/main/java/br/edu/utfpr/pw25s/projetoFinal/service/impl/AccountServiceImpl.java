package br.edu.utfpr.pw25s.projetoFinal.service.impl;

import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.model.User;
import br.edu.utfpr.pw25s.projetoFinal.repository.AccountRepository;
import br.edu.utfpr.pw25s.projetoFinal.repository.UserRepository;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;
import br.edu.utfpr.pw25s.projetoFinal.service.LoggedUserUtilsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends CrudServiceImpl<Account, Long> implements AccountService {

    private static AccountRepository accountRepository;

    private static LoggedUserUtilsService loggedUserUtilsService;

    public AccountServiceImpl(AccountRepository accountRepository, LoggedUserUtilsService loggedUserUtilsService) {
        this.accountRepository = accountRepository;
        this.loggedUserUtilsService = loggedUserUtilsService;
    }

    @Override
    protected JpaRepository<Account, Long> getRepository() {
        return this.accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findByUserUsername(
            loggedUserUtilsService.retornaObjetoDoUsuarioLogado().getUsername()
        );
    }

    @Override
    public Account save(Account entity) {
        entity.setUser(
            loggedUserUtilsService.retornaObjetoDoUsuarioLogado()
        );
        return super.save(entity);
    }
}
