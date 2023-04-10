package com.quizlet.app.model.typeClass;

import com.quizlet.app.model.GeneralEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisplayStatus extends GeneralEntity {
    private String nameDisplay;


    public DisplayStatus(Integer idDisplayStatus) {
        this.setId(idDisplayStatus);
    }
}
