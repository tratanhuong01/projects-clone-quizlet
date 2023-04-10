package com.quizlet.app.api;



import com.quizlet.app.dto.GeneralDTO;
import com.quizlet.app.model.GeneralEntity;
import org.springframework.data.domain.Page;

public interface AbstractCRUDApi<ENTITY extends GeneralEntity, DTO extends GeneralDTO> {
    DTO save(DTO dto);
    DTO getById(Integer id);
    Page<DTO> list(Integer index);
    boolean delete(Integer id);

}
