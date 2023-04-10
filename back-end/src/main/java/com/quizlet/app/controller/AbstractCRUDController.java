package com.quizlet.app.controller;

import com.quizlet.app.api.AbstractCRUDApi;

import com.quizlet.app.dto.GeneralDTO;
import com.quizlet.app.model.GeneralEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

public class AbstractCRUDController<ENTITY extends GeneralEntity, DTO extends GeneralDTO> {

    private AbstractCRUDApi<ENTITY, DTO> api;

    public AbstractCRUDController(AbstractCRUDApi<ENTITY, DTO> api) {
        this.api = api;
    }



    @PostMapping
    public DTO save(@RequestBody DTO dto) {
        return api.save(dto);
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable Integer id) {
        return api.getById(id);
    }

    @GetMapping("/list")
    public Page<DTO> list(@RequestParam(value = "index",defaultValue = "0") Integer index) {
        return api.list(index);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return api.delete(id);
    }

}
