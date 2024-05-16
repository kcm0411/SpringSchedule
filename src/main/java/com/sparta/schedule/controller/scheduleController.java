package com.sparta.schedule.controller;

import com.sparta.schedule.dto.RequestDto;
import com.sparta.schedule.dto.ResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class scheduleController {

    private final ScheduleRepository scheduleRepository;

    public scheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @PostMapping("/schedule")
    public ResponseDto createSchedule(@RequestBody RequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto);
        scheduleRepository.save(schedule);
        Schedule scheduleResponse = scheduleRepository.getReferenceById(schedule.getId());
        return new ResponseDto(scheduleResponse);
    }

    @GetMapping("/schedule/{id}")
    public ResponseDto getSchedules(@PathVariable Long id) {

        Schedule schedule = scheduleRepository.getReferenceById(id);
        return new ResponseDto(schedule);

    }

    @GetMapping("/schedules")
    public List<ResponseDto> getAllSchedules() {
        return scheduleRepository.findAllByOrderByDateTimeDesc().stream().map(ResponseDto::new).toList();

    }

    @PutMapping("/schedule/{id}/{pw}")
    public ResponseDto updateSchedule(@PathVariable Long id, @PathVariable String pw, @RequestBody RequestDto requestDto) throws IllegalAccessException {

        Schedule schedule = scheduleRepository.getReferenceById(id);
        if (schedule.getPw().equals(pw)) {

            schedule.update(requestDto);
            scheduleRepository.save(schedule);
            Schedule scheduleResponse = scheduleRepository.getReferenceById(schedule.getId());
            return new ResponseDto(scheduleResponse);

        } else {
            throw new IllegalAccessException("비밀번호가 맞지 않습니다.");
        }
    }

    @DeleteMapping("/schedule/{id}/{pw}")
    public Long deleteSchedule(@PathVariable Long id, @PathVariable String pw) throws IllegalAccessException {
        Schedule schedule = scheduleRepository.getReferenceById(id);
        if (schedule.getPw().equals(pw)) {
            scheduleRepository.delete(schedule);
            return schedule.getId();
        } else {
            throw new IllegalAccessException("비밀번호가 맞지 않습니다.");
        }
    }
}
