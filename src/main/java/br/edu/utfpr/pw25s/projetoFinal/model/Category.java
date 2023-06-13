package br.edu.utfpr.pw25s.projetoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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

    @JsonIgnore
    @ManyToOne
    private User user;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notNull.message}")
    @NotEmpty(message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.notEmpty.message}")
    private String name;
    @Length(max = 255, message = "{br.edu.utfpr.pw25s.projetoFinal.category.name.length.message}")
    private String description;

}
