package com.quizlet.app.converter;

import com.quizlet.app.dto.DetailUnitDTO;
import com.quizlet.app.model.unit.DetailUnit;
import org.springframework.stereotype.Component;

@Component
public class DetailUnitConverter implements AbstractDTOConverter<DetailUnit, DetailUnitDTO> {
    @Override
    public DetailUnitDTO convertDetail(DetailUnit detailUnit) {
        return new DetailUnitDTO(detailUnit);
    }
}
