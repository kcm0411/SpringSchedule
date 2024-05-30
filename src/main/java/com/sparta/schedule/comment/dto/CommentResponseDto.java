package com.sparta.schedule.comment.dto;

import com.sparta.schedule.comment.entity.Comment;
import com.sparta.schedule.schedule.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private Long id;
    private String content;
//    private String userId;
//    private Schedule schedule;
    private Long scheduleId;
    private LocalDateTime dateTime;

    public CommentResponseDto(Comment comment) {

        this.id = comment.getId();
        this.content = comment.getContent();
//        this.userId = comment.getUserId();
//        this.schedule = comment.getSchedule();
        this.scheduleId = comment.getSchedule().getId();
        this.dateTime = comment.getDateTime();

    }
}
