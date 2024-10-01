package ar.edu.utn.frc.tup.lc.iv.repositories;

import ar.edu.utn.frc.tup.lc.iv.entities.ProductsCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsCategoriesRepository extends JpaRepository<ProductsCategoriesEntity, Long> {
}
