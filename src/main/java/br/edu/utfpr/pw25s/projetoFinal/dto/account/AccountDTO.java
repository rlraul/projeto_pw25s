package br.edu.utfpr.pw25s.projetoFinal.dto.account;

import br.edu.utfpr.pw25s.projetoFinal.model.User;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountDTO {

    private long id;

    @NotNull
    private int number;

    @NotNull
    private int agency;

    @NotNull
    private int bank;

    @NotNull
    @DecimalMin("0")
    private BigDecimal amount;

    private User user;

}
