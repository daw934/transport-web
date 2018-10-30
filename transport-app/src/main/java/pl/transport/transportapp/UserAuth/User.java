package pl.transport.transportapp.UserAuth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.transport.transportapp.validator.PasswordMatches;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@ToString
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(max=60)
    @PasswordMatches
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    @Column(name = "enabled")
    private boolean enabled;

    public User() {
        this.enabled = false;
    }

}