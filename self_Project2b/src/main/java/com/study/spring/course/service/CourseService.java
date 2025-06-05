package com.study.spring.course.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.study.spring.course.dto.CourseRequestDto;
import com.study.spring.course.dto.CoursesDto;

public interface CourseService {

	CoursesDto createCourse(CourseRequestDto requestDto);
	CoursesDto getCourse(Long courseId);
    CoursesDto updateCourse(Long courseId, CourseRequestDto requestDto);
    void deleteCourse(Long courseId);
    
    List<CoursesDto> getCoursesByMember(Long memberId);
    List<CoursesDto> getTop8Courses(String sort);
//	ResponseEntity<List<CoursesDto>> searchCourses(String keyword);
}
