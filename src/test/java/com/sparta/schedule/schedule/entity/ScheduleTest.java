package com.sparta.schedule.schedule.entity;

import com.sparta.schedule.schedule.dto.RequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    @DisplayName("Schedule Update Method")
    public void testScheduleUpdate(){

        // given
        Schedule schedule = new Schedule();
        String updateTitle = "title 업데이트";
        String updateContents = "contents 업데이트";
        String updateManager = "manager 업데이트";
        String updatePw = "pw 업데이트";

        RequestDto requestDto = new RequestDto(updateTitle, updateContents, updateManager, updatePw);

        // when
        schedule.update(requestDto);

        // then
        assertEquals(updateTitle,schedule.getTitle());
        assertEquals(updateContents,schedule.getContents());
        assertEquals(updateManager,schedule.getManager());
        assertEquals(updatePw,schedule.getPw());


    }

}