package com.quizlet.app.controller;

import com.quizlet.app.api.AbstractCRUDApi;
import com.quizlet.app.dto.UnitDTO;
import com.quizlet.app.model.unit.Unit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit")
public class UnitController extends AbstractCRUDController<Unit, UnitDTO> {
    public UnitController(AbstractCRUDApi<Unit, UnitDTO> api) {
        super(api);
    }
}
