package br.edu.utfpr.pw25s.projetoFinal.model;

import br.edu.utfpr.pw25s.projetoFinal.enums.MovementSituation;
import br.edu.utfpr.pw25s.projetoFinal.enums.MovementType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "financialMovement")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class FinancialMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull
    @NotEmpty
    private BigDecimal value;

    @NotNull
    @NotEmpty
    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private MovementSituation situation;

    @NotNull
    @NotEmpty
    private MovementType type;

}
