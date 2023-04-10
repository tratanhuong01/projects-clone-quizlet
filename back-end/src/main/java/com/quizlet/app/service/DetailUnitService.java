package com.quizlet.app.service;

import com.quizlet.app.converter.AbstractDTOConverter;
import com.quizlet.app.dto.DetailUnitDTO;
import com.quizlet.app.model.unit.DetailUnit;
import com.quizlet.app.repository.GeneralRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailUnitService extends AbstractCRUDService<DetailUnit, DetailUnitDTO> {

    public DetailUnitService(GeneralRepository<DetailUnit> repository, AbstractDTOConverter<DetailUnit, DetailUnitDTO> converter) {
        super(repository, converter);
    }

    @Override
    public DetailUnit updateEntity(DetailUnit entity, DetailUnitDTO dto) {
        return new DetailUnit(dto);
    }
}
