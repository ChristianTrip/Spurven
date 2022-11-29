package couchpotatoes.spurven.application.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import couchpotatoes.spurven.security.entity.UserWithRoles;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
