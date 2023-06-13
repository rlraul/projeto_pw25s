package br.edu.utfpr.pw25s.projetoFinal.dto.account;

import br.edu.utfpr.pw25s.projetoFinal.model.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountDTO {

    private long id;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.name.NotNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.account.name.NotEmpty.message}")
    @Length(min = 1, max = 30, message = "{br.edu.utfpr.pw25s.projetoFinal.account.name.length.message}")
    private String name;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.number.NotNull.message}")
    private int number;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.agency.NotNull.message}")
    private int agency;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.bank.NotNull.message}")
    private int bank;

    @NotNull
    @DecimalMin("0")
    private BigDecimal amount;

}
