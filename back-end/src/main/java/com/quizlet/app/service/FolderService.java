package com.quizlet.app.service;

import com.quizlet.app.converter.AbstractDTOConverter;
import com.quizlet.app.dto.FolderDTO;
import com.quizlet.app.model.folder.Folder;
import com.quizlet.app.repository.GeneralRepository;
import org.springframework.stereotype.Service;

@Service
public class FolderService extends AbstractCRUDService<Folder, FolderDTO> {
    public FolderService(GeneralRepository<Folder> repository, AbstractDTOConverter<Folder, FolderDTO> converter) {
        super(repository, converter);
    }

    @Override
    public Folder updateEntity(Folder folder, FolderDTO folderDTO) {
        return new Folder(folderDTO);
    }
}
