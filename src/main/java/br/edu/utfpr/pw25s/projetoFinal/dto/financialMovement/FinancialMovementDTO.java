package br.edu.utfpr.pw25s.projetoFinal.dto.financialMovement;

import br.edu.utfpr.pw25s.projetoFinal.enums.MovementSituation;
import br.edu.utfpr.pw25s.projetoFinal.enums.MovementType;
import br.edu.utfpr.pw25s.projetoFinal.model.Account;
import br.edu.utfpr.pw25s.projetoFinal.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FinancialMovementDTO {

    private Long id;

    @NotNull
    private Account account;

    private Account accountToTransfer;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal value;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime date;

    @NotNull
    private Category category;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private MovementSituation situation;

    @NotNull
    private MovementType type;
}
