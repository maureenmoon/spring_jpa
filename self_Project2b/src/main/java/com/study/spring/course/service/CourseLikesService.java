package com.study.spring.course.service;

public interface CourseLikesService {
	int likeCourse(Long courseId, Long memberId);

	int unlikeCourse(Long courseId, Long memberId);

}
