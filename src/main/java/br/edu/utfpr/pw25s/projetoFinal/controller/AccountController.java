package br.edu.utfpr.pw25s.projetoFinal.controller;

import br.edu.utfpr.pw25s.projetoFinal.dto.account.AccountDTO;
import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.service.AccountService;
import br.edu.utfpr.pw25s.projetoFinal.service.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController extends CrudController<Account, AccountDTO, Long>{

    private static AccountService accountService;

    private static ModelMapper modelMapper;

    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        super(Account.class, AccountDTO.class);
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected CrudService<Account, Long> getService() {
        return this.accountService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

}
