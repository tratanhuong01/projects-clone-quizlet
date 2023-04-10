package com.quizlet.app.dto;

import com.quizlet.app.model.unit.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UnitDTO extends GeneralDTO{
    private String nameUnit;
    private String descriptionUnit;
    private Integer idDisplayStatus;
    private Integer idEditStatus;
    private String topicName;
    private Long topicId;
    private String userName;
    private Integer idUser;

    public UnitDTO(Unit unit) {
        this.setId(unit.getId());
        this.setTimeCreated(unit.getTimeCreated());
        this.nameUnit = unit.getNameUnit();
        this.descriptionUnit = unit.getDescriptionUnit();
        this.idDisplayStatus = unit.getDisplayStatus().getId();
        this.idEditStatus = unit.getEditStatus().getId();
        this.topicName = unit.getTopic().getNameTopic();
        this.topicId = unit.getTopic().getId();
        this.userName = unit.getUser().getUsername();
    }
}
