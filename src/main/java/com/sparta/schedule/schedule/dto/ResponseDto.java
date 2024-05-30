package com.sparta.schedule.schedule.dto;

import com.sparta.schedule.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String manager;
    private LocalDateTime dateTime;

    public ResponseDto(Schedule schedule) {

        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.dateTime = schedule.getDateTime();

    }
}
