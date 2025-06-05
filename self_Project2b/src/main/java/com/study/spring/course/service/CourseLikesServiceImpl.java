package com.study.spring.course.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.course.entity.CourseLikes;
import com.study.spring.course.entity.Courses;
import com.study.spring.course.repository.CourseLikesRepository;
import com.study.spring.course.repository.CoursesRepository;
import com.study.spring.member.entity.Members;
import com.study.spring.member.repository.MembersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CourseLikesServiceImpl implements CourseLikesService {
	
	private final CoursesRepository coursesRepository;
	private final MembersRepository membersRepository;
	private final CourseLikesRepository courseLikesRepository;
	
	@Override
	@Transactional
	public int likeCourse(Long courseId, Long memberId) {
		Courses course = coursesRepository.findById(courseId)
				.orElseThrow(()->new IllegalArgumentException("Course not found"));
		Members	member = membersRepository.findById(memberId)
				.orElseThrow(()->new IllegalArgumentException("Course not found"));

//		if (courseLikesRepository.existsByCourseAndMember(course, member)) {
//			throw new IllegalStateException("already liked this course");
//		}
		
		boolean alreadyLiked = courseLikesRepository.existsByCourseAndMember(course, member);
	
		if (!alreadyLiked) {
			CourseLikes like = new CourseLikes();
			like.setCourse(course);
			like.setMember(member);
			courseLikesRepository.save(like);
		}
		
		return courseLikesRepository.countByCourse(course);
	}
	
	@Override
	@Transactional
	public int unlikeCourse(Long courseId, Long memberId) {
		Courses course = coursesRepository.findById(courseId).orElseThrow();
		Members member = membersRepository.findById(memberId).orElseThrow();
		CourseLikes like = courseLikesRepository.findByCourseAndMember(course, member)
				.orElseThrow(()->new IllegalStateException("Like not found"));
		courseLikesRepository.delete(like);
				
		return courseLikesRepository.countByCourse(course);
	}
	
	

}
