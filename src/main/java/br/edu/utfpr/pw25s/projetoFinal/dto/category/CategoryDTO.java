package br.edu.utfpr.pw25s.projetoFinal.dto.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    private long id;

    @NotNull
    @NotEmpty
    private String name;

}
