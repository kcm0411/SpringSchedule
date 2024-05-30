package com.sparta.schedule.comment.entity;

import com.sparta.schedule.Timestamped;
import com.sparta.schedule.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

//    @Column(name = "user_id", nullable = false)
//    private String userId;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime dateTime;

    public Comment(String content, Schedule schedule) {
        this.content = content;
        this.schedule = schedule;
    }
}