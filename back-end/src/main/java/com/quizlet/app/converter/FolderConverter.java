package com.quizlet.app.converter;

import com.quizlet.app.dto.FolderDTO;
import com.quizlet.app.model.folder.Folder;
import org.springframework.stereotype.Component;

@Component
public class FolderConverter implements AbstractDTOConverter<Folder, FolderDTO> {
    @Override
    public FolderDTO convertDetail(Folder folder) {
        return new FolderDTO(folder);
    }
}
