package ar.edu.utn.frc.tup.lc.iv.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products_States")
public class StateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "state")
    String state;

    @Column(name = "created_datetime")
    LocalDateTime createdDatetime;

    @Column(name = "created_user")
    Integer createdUser;

    @Column(name = "last_updated_datetime")
    LocalDateTime lastUpdatedDatetime;

    @Column(name = "last_updated_user")
    Integer lastUpdatedUser;
}
