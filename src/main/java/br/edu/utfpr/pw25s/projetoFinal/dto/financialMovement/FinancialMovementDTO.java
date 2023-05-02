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

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.value.NotNull.message}")
    @DecimalMin(value = "0.01", message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.value.Min.message}")
    private BigDecimal value;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.date.NotNull.message}")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime date;

    @NotNull
    private Category category;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.description.NotNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.description.NotEmpty.message}")
    private String description;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.situation.NotNull.message}")
    private MovementSituation situation;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.financialMovement.type.NotNull.message}")
    private MovementType type;
}
