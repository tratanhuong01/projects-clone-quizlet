package com.quizlet.app.dto;

import com.quizlet.app.model.folder.Folder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FolderDTO extends GeneralDTO{
    String nameFolderTopic;
    String descriptionFolderTopic;
    String userName;
    Integer idUser;

    public FolderDTO(Folder folder) {
        this.setId(folder.getId());
        this.setTimeCreated(folder.getTimeCreated());
        this.nameFolderTopic = folder.getNameFolderTopic();
        this.descriptionFolderTopic = folder.getDescriptionFolderTopic();
        this.userName = folder.getUser().getUsername();
    }
}
