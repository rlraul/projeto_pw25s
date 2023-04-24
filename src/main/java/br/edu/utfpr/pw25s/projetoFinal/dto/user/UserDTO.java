package br.edu.utfpr.pw25s.projetoFinal.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

//    @UniqueUsername
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @NotNull
    @Size(min = 4, max = 50)
    private String displayName;

    @NotNull(message = "{br.edu.utfpr.pb.pw26s.server.user.password.constraints.NotNull.message}")
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{br.edu.utfpr.pb.pw26s.server.user.password.constraints.Pattern.message}")
    private String password;

}
