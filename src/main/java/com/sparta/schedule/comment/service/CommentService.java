package com.sparta.schedule.comment.service;

import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.comment.entity.Comment;
import com.sparta.schedule.comment.repository.CommentRepository;
import com.sparta.schedule.schedule.entity.Schedule;
import com.sparta.schedule.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new RuntimeException("Comment not found"));

        comment.updateComment(commentRequestDto.getContent());
        return new CommentResponseDto(comment);

    }
}
