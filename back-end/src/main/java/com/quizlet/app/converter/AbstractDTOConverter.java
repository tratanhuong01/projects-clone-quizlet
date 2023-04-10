package com.quizlet.app.converter;

import com.quizlet.app.dto.GeneralDTO;
import com.quizlet.app.model.GeneralEntity;

public interface AbstractDTOConverter<ENTITY extends GeneralEntity, DTO extends GeneralDTO> {
    public DTO convertDetail(ENTITY entity);
}
