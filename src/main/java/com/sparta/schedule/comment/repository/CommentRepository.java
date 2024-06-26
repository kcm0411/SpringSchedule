package com.sparta.schedule.comment.repository;

import com.sparta.schedule.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}