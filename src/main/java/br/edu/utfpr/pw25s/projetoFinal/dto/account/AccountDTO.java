package br.edu.utfpr.pw25s.projetoFinal.dto.account;

import br.edu.utfpr.pw25s.projetoFinal.model.User;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountDTO {

    private long id;

    @NotNull
    private int number;

    @NotNull
    private int agency;

    @NotNull
    private int bank;

    private User user;

}
