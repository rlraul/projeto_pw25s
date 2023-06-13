package br.edu.utfpr.pw25s.projetoFinal.dto.category;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    private long id;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notEmpty.message}")
    private String name;

    @Length(max = 255, message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.length.message}")
    private String description;

}
