package com.quizlet.app.dto;

import com.quizlet.app.model.unit.DetailUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailUnitDTO extends GeneralDTO{
    String term;
    String definition;
    String image;
    String unitName;
    Integer unitId;
    public DetailUnitDTO(DetailUnit detailUnit) {
        this.setId(detailUnit.getId());
        this.setTimeCreated(detailUnit.getTimeCreated());
        this.term = detailUnit.getTerm();
        this.definition = detailUnit.getDefinition();
        this.image = detailUnit.getImage();
        this.unitName = detailUnit.getUnit().getNameUnit();
    }
}
