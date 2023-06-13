package br.edu.utfpr.pw25s.projetoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.account.name.NotNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.account.name.NotEmpty.message}")
    @Length(min = 1, max = 30, message = "{br.edu.utfpr.pw25s.projetoFinal.account.name.length.message}")
    private String name;

    @JsonIgnore
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
