package ar.edu.utn.frc.tup.lc.iv.Services;

import ar.edu.utn.frc.tup.lc.iv.Entities.StateEntity;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.State.DtoGetStateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStateService {
    List<DtoGetStateResponse> getStates();
}
