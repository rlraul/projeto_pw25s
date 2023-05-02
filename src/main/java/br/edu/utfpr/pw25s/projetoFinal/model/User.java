package br.edu.utfpr.pw25s.projetoFinal.model;

import br.edu.utfpr.pw25s.projetoFinal.annotation.UniqueUsername;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @UniqueUsername
    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.user.username.constraints.NotNull.message}")
    @Size(min = 4, max = 50, message = "{br.edu.utfpr.pw25s.projetoFinal.user.username.constraints.Size.message}")
    @Column(length = 50)
    private String username;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(length = 50, name = "display_name")
    private String displayName;

    @NotNull(message = "{br.edu.utfpr.pw25s.projetoFinal.user.password.constraints.NotNull.message}")
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{br.edu.utfpr.pw25s.projetoFinal.user.password.constraints.Pattern.message}")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
