package br.edu.utfpr.pw25s.projetoFinal.dto.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    private long id;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notEmpty.message}")
    private String name;

}
