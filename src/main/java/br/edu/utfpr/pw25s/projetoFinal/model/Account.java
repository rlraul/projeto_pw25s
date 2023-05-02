package br.edu.utfpr.pw25s.projetoFinal.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

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
