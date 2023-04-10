package com.quizlet.app.model.unit;

import com.quizlet.app.dto.DetailUnitDTO;
import com.quizlet.app.model.GeneralEntity;
import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailUnit extends GeneralEntity {
    String term;
    String definition;
    String image;
    @ManyToOne
    @JoinColumn(name = "id_unit" , nullable = false)
    Unit unit;

    public DetailUnit(DetailUnitDTO detailUnitDTO) {
        this.setId(detailUnitDTO.getId());
        this.setTimeCreated(detailUnitDTO.getTimeCreated());
        this.term = detailUnitDTO.getTerm();
        this.definition = detailUnitDTO.getDefinition();
        this.image = detailUnitDTO.getImage();
        this.unit = new Unit(detailUnitDTO.getUnitId());
    }
}
