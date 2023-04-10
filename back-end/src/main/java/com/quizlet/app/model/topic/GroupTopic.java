package com.quizlet.app.model.topic;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nameGroupTopic;

    String imageGroupTopic;

    @Column(name = "timeCreated")
    @CreatedDate
    Date timeCreated;


}
