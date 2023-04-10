package com.quizlet.app.model.topic;

import com.quizlet.app.model.folder.Folder;
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
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "id_folder_topic")
    Folder folderTopic;
    @ManyToOne
    @JoinColumn(name = "id_group_topic")
    GroupTopic groupTopic;

    String nameTopic;
    @Column(name = "timeCreated")
    @CreatedDate
    Date timeCreated;


    public Topic(Long topicId) {
        this.id = topicId;
    }
}
