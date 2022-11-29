package couchpotatoes.spurven.application.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import couchpotatoes.spurven.security.dto.UserWithRolesRequest;
import couchpotatoes.spurven.security.entity.Role;
import couchpotatoes.spurven.security.entity.UserWithRoles;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class User extends UserWithRoles {

    @Column(length = 255)
    private String firstName;
    @Column(length = 255)
    private String lastName;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String phone;

    public User(UserWithRolesRequest body, String firstName, String lastName, String email, String phone) {
        super(body);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password, String firstName, String lastName, String email, String phone) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

}
