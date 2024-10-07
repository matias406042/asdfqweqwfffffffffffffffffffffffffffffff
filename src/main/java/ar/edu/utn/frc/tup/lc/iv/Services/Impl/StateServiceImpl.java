package ar.edu.utn.frc.tup.lc.iv.Services.Impl;

import ar.edu.utn.frc.tup.lc.iv.Entities.CategoryEntity;
import ar.edu.utn.frc.tup.lc.iv.Entities.StateEntity;
import ar.edu.utn.frc.tup.lc.iv.Repositories.StateJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.Services.IStateService;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.State.DtoGetStateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateServiceImpl implements IStateService {

    @Autowired
    StateJpaRepository stateRepository;

    @Override
    public List<DtoGetStateResponse> getStates() {
        List<StateEntity> dataList = stateRepository.findAll();
        List<DtoGetStateResponse> listStates = new ArrayList<>();

        if (dataList.isEmpty()) return null;
        for (StateEntity entity : dataList) { listStates.add(new DtoGetStateResponse(entity.getId(), entity.getState())); }

        return listStates;
    }
}
