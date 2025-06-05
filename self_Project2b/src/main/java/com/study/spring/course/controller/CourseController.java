package com.study.spring.course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.spring.course.dto.CourseRequestDto;
import com.study.spring.course.dto.CoursesDto;
import com.study.spring.course.entity.CourseLikes;
import com.study.spring.course.service.CourseLikesService;
import com.study.spring.course.service.CourseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//@RestController auto-convers return to JSON
//ResponseEnity allows setting HTTP status, headers, and body
//@RequestBody binds JSON request body to a Java object
//@PathVariable extracts a variable part from URL (e.g. /courses/2)

	@RestController  
	@RequiredArgsConstructor
	@RequestMapping("/courses")
	@Log4j2
	public class CourseController {

	    private final CourseService courseService;

	    //1.create
	    @PostMapping
	    public ResponseEntity<CoursesDto> createCourse( 
	        @RequestBody CourseRequestDto requestDto
	    ) {
	        return ResponseEntity.ok(courseService.createCourse(requestDto));
	    }
	    
	    //2.read by ID
	    @GetMapping("/{courseId}")
	    public ResponseEntity<CoursesDto> getCourse(
	    		@PathVariable("courseId") Long courseId) {
	    	return ResponseEntity.ok(courseService.getCourse(courseId));
	    }

	    //3.read by member ID
	    @GetMapping("/member/{memberId}")
	    public ResponseEntity<List<CoursesDto>> getCoursesByMember(
	    		@PathVariable("memberId") Long memberId) {
	        return ResponseEntity.ok(courseService.getCoursesByMember(memberId));
	    }
	    
//	    @GetMapping("/search")
//	    public List<CoursesDto> search(@RequestParam String keyword) {
//	    	return courseService.searchCourses(keyword);
//	    }
	    
	    //delete
	    @DeleteMapping("/{courseId}")
	    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId){
	    	courseService.deleteCourse(courseId);
//	    	return ResponseEntity.noContent().build();
	    	return ResponseEntity.ok().build();
	    }
	    
	    //update
	    @PutMapping("/{courseId}")
	    public ResponseEntity<CoursesDto> updateCourse(
	    		@PathVariable("courseId") Long courseId,
	    		@RequestBody CourseRequestDto requestDto
	    		) {
	    	return ResponseEntity.ok(courseService.updateCourse(courseId, requestDto));
	    }
	    
	    //list-top8
	    @GetMapping("/top8")
	    public ResponseEntity<List<CoursesDto>> getTop8Courses(
	    		@RequestParam(name = "sort", defaultValue = "recent") String sort
	    		) {
	        log.info("[DEBUG] Controller called with sort={} " + sort);
	    	return ResponseEntity.ok(courseService.getTop8Courses(sort));
	    	
//	    	http://localhost:8080/courses/top8?sort=recent
//	    	http://localhost:8080/courses/top8?sort=popular
//	    	http://localhost:8080/courses/top8   // uses default: recent	    	
	    }
	    
}

	
	
	
	
	
	
	