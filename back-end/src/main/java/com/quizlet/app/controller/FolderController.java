package com.quizlet.app.controller;

import com.quizlet.app.api.AbstractCRUDApi;
import com.quizlet.app.dto.FolderDTO;
import com.quizlet.app.model.folder.Folder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/folder")
public class FolderController extends AbstractCRUDController<Folder, FolderDTO> {
    public FolderController(AbstractCRUDApi<Folder, FolderDTO> api) {
        super(api);
    }
}
