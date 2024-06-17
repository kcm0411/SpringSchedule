package com.sparta.schedule.comment.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    @DisplayName("Comment 업데이트 테스트(entity)")
    public void testCommentUpdate(){

        // given : 테스트 데이터 넣기
        String content = "변경할 content";
        Comment comment = new Comment();

        // when
        comment.updateComment(content);

        // then
        assertEquals(content,comment.getContent());

    }

}