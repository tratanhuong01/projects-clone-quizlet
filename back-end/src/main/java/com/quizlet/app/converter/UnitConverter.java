package com.quizlet.app.converter;

import com.quizlet.app.dto.UnitDTO;
import com.quizlet.app.model.unit.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitConverter implements AbstractDTOConverter<Unit, UnitDTO> {
    @Override
    public UnitDTO convertDetail(Unit unit) {
        return new UnitDTO(unit);
    }
}
