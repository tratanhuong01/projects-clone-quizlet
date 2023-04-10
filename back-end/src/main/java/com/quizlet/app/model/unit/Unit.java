package com.quizlet.app.model.unit;

import com.quizlet.app.dto.UnitDTO;
import com.quizlet.app.model.account.User;
import com.quizlet.app.model.GeneralEntity;
import com.quizlet.app.model.topic.Topic;
import com.quizlet.app.model.typeClass.DisplayStatus;
import com.quizlet.app.model.typeClass.EditStatus;
import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unit extends GeneralEntity {
    String nameUnit;
    String descriptionUnit;
    @ManyToOne
    @JoinColumn(name = "id_display_status")
    DisplayStatus displayStatus;
    @ManyToOne
    @JoinColumn(name = "id_edit_status")
    EditStatus editStatus;
    @ManyToOne
    @JoinColumn(name = "id_topic", nullable = false)
    Topic topic;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    User user;

    public Unit(Integer unitId) {
        this.setId(unitId);
    }

    public Unit(UnitDTO unitDTO) {
        this.setId(unitDTO.getId());
        this.setTimeCreated(unitDTO.getTimeCreated());
        this.nameUnit = unitDTO.getNameUnit();
        this.descriptionUnit = unitDTO.getDescriptionUnit();
        this.displayStatus = new DisplayStatus(unitDTO.getIdDisplayStatus());
        this.editStatus = new EditStatus(unitDTO.getIdEditStatus());
        this.topic = new Topic(unitDTO.getTopicId());
        this.user = new User(unitDTO.getIdUser());
    }
}
