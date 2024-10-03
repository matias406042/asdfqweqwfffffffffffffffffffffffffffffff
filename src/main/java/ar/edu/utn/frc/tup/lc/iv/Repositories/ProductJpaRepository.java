package ar.edu.utn.frc.tup.lc.iv.Repositories;

import ar.edu.utn.frc.tup.lc.iv.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity,Integer> {

}
