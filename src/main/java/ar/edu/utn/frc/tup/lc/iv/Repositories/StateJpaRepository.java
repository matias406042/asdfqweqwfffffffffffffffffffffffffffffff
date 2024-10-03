package ar.edu.utn.frc.tup.lc.iv.Repositories;

import ar.edu.utn.frc.tup.lc.iv.Entities.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateJpaRepository extends JpaRepository<StateEntity,Integer> {

}
