package ar.edu.utn.frc.tup.lc.iv.repositories;

import ar.edu.utn.frc.tup.lc.iv.entities.AmountModificationEntity;
import ar.edu.utn.frc.tup.lc.iv.models.AmountModification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountModificationJpaRepository extends JpaRepository<AmountModificationEntity, Integer> {
}
