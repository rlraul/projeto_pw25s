package br.edu.utfpr.pw25s.projetoFinal.dto.user;

import br.edu.utfpr.pw25s.projetoFinal.annotation.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @UniqueUsername
    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.user.username.constraints.NotNull.message}")
    @Size(min = 4, max = 50, message = "{br.edu.utfpr.pw25s.projetoFinal.user.username.constraints.Size.message}")
    private String username;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.user.displayName.constraints.NotNull.message}")
    @Size(min = 2, max = 80, message = "{br.edu.utfpr.pw25s.projetoFinal.user.displayName.constraints.Size.message}")
    private String displayName;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.user.password.constraints.NotNull.message}")
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{br.edu.utfpr.pw25s.projetoFinal.user.password.constraints.Pattern.message}")
    private String password;

}
