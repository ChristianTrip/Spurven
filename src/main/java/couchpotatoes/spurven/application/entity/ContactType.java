package couchpotatoes.spurven.application.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//---------------Lombok.
@Entity
public class ContactType {

    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private String id;

    @OneToMany(mappedBy = "contactType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Contact> contacts = new ArrayList<>();

}
