package ar.edu.utn.frc.tup.lc.iv.repositories;


import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DetailProductJpaRepository extends JpaRepository<DetailProductEntity, Integer> {
    Optional<List<DetailProductEntity>> findAllByProductId (Integer id);
}
