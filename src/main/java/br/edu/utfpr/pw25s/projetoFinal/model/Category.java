package br.edu.utfpr.pw25s.projetoFinal.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notEmpty.message}")
    private String name;

}
