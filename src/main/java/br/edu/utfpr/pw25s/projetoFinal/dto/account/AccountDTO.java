package br.edu.utfpr.pw25s.projetoFinal.dto.account;

import br.edu.utfpr.pw25s.projetoFinal.model.User;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountDTO {

    private long id;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.number.NotNull.message}")
    private int number;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.agency.NotNull.message}")
    private int agency;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.bank.NotNull.message}")
    private int bank;

    @NotNull
    @DecimalMin("0")
    private BigDecimal amount;

    private User user;

}
