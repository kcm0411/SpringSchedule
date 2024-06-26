package com.sparta.schedule.schedule.repository;

import com.sparta.schedule.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByOrderByDateTimeDesc();

}
