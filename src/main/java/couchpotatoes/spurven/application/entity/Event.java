package couchpotatoes.spurven.application.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

//---------------Lombok.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//---------------Lombok.

@Entity
public class Event {
    //---------------Fields / attribute.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255,nullable = false)
    private String title;
    @Column(length = 255,nullable = false)
    private String description;

    @Column(length = 255,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime start;
    @Column(length = 255,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime end;

    @CreationTimestamp
    LocalDateTime created;
    @UpdateTimestamp
    LocalDateTime edited;
    //---------------Fields / attribute.





    //---------------Database dependencies.
    //---------------Database dependencies.

    //---------------Reservation class.
    //---------------Reservation class.

    //---------------Constructor.
    //---------------Constructor.

}
