package br.edu.utfpr.pw25s.projetoFinal.model;

import br.edu.utfpr.pw25s.projetoFinal.enums.MovementSituation;
import br.edu.utfpr.pw25s.projetoFinal.enums.MovementType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table
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
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "account_to_transfer_id", referencedColumnName = "id")
    private Account accountToTransfer;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.value.NotNull.message}")
    @DecimalMin(value = "0.01", message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.value.Min.message}")
    private BigDecimal value;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.date.NotNull.message}")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.description.NotNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.description.NotEmpty.message}")
    private String description;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.situation.NotNull.message}")
    @Enumerated(EnumType.ORDINAL)
    private MovementSituation situation;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.type.NotNull.message}")
    @Enumerated(EnumType.ORDINAL)
    private MovementType type;
}
