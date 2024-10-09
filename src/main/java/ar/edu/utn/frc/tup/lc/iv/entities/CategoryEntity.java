package ar.edu.utn.frc.tup.lc.iv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products_Categories")
public class CategoryEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "category")
    String category;

    @Column(name = "created_datetime")
    LocalDateTime createdDatetime;

    @Column(name = "created_user")
    Integer createdUser;

    @Column(name = "last_updated_datetime")
    LocalDateTime lastUpdatedDatetime;

    @Column(name = "last_updated_user")
    Integer lastUpdatedUser;
}
