package com.quizlet.app.controller;

import com.quizlet.app.api.AbstractCRUDApi;
import com.quizlet.app.dto.DetailUnitDTO;
import com.quizlet.app.model.unit.DetailUnit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detailUnit")
public class DetailUnitController extends AbstractCRUDController<DetailUnit, DetailUnitDTO> {
    public DetailUnitController(AbstractCRUDApi<DetailUnit, DetailUnitDTO> api) {
        super(api);
    }
}
