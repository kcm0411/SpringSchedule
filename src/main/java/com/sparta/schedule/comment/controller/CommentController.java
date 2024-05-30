package com.sparta.schedule.comment.controller;

import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{scheduleId}/comment")
    public CommentResponseDto addComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.addComment(scheduleId, commentRequestDto);
    }

}
