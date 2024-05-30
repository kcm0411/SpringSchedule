package com.sparta.schedule.comment.service;

import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.comment.entity.Comment;
import com.sparta.schedule.comment.repository.CommentRepository;
import com.sparta.schedule.schedule.entity.Schedule;
import com.sparta.schedule.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto addComment(Long scheduleId, CommentRequestDto commentRequestDto) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new RuntimeException("Schedule not found"));

        Comment comment = commentRepository.save(new Comment(commentRequestDto.getContent(), schedule));
        return new CommentResponseDto(comment);
    }

}
