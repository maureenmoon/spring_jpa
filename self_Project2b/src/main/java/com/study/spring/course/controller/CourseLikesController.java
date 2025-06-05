package com.study.spring.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.course.service.CourseLikesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseLikesController {
	
	private final CourseLikesService courseLikesService;
	
	@PostMapping("/{courseId}/like")
	public ResponseEntity<Integer> likeCourse(
			@PathVariable("courseId") Long courseId,
			@RequestParam(name="memberId") Long memberId  // ✅ Ensure name is clearly specified
			){
		int likeCount = courseLikesService.likeCourse(courseId, memberId);
		
		return ResponseEntity.ok(likeCount);
	}
	
	@DeleteMapping("/{courseId}/like")
	public ResponseEntity<Integer> unlikeCourse(
			@PathVariable("courseId") Long courseId,
			@RequestParam(name="memberId") Long memberId  //
			){
		int likeCount = courseLikesService.likeCourse(courseId, memberId);
		
		return ResponseEntity.ok(likeCount);
	}


}
