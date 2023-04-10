package com.quizlet.app.service;

import com.quizlet.app.converter.AbstractDTOConverter;
import com.quizlet.app.dto.UnitDTO;
import com.quizlet.app.model.unit.Unit;
import com.quizlet.app.repository.GeneralRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitService extends AbstractCRUDService<Unit, UnitDTO> {
    public UnitService(GeneralRepository<Unit> repository, AbstractDTOConverter<Unit, UnitDTO> converter) {
        super(repository, converter);
    }

    @Override
    public Unit updateEntity(Unit unit, UnitDTO unitDTO) {
        return new Unit(unitDTO);
    }
}
