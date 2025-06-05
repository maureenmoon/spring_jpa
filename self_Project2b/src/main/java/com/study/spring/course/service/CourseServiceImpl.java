package com.study.spring.course.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.course.dto.CourseLikeCountDto;
import com.study.spring.course.dto.CourseRequestDto;
import com.study.spring.course.dto.CoursesDto;
import com.study.spring.course.entity.Courses;
import com.study.spring.course.repository.CourseLikesRepository;
import com.study.spring.course.repository.CoursesRepository;
import com.study.spring.member.dto.MembersDto;
import com.study.spring.member.entity.Members;
import com.study.spring.member.repository.MembersRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CourseServiceImpl implements CourseService{
	
	private final CoursesRepository coursesRepository;
	private final MembersRepository membersRepository;
	private final CourseLikesRepository courseLikesRepository;
	
	//create
	@Override
	public CoursesDto createCourse(CourseRequestDto requestDto) {		
		Courses course = new Courses();		
		course.setTitle(requestDto.getTitle());
        course.setContent(requestDto.getContent());
        course.setAreaCode(requestDto.getAreaCode());
        course.setSigunguCode(requestDto.getSigunguCode());
        course.setCrdttm(LocalDateTime.now());
        Members member = membersRepository.findById(requestDto.getMemberId())
        		.orElseThrow(()-> new IllegalArgumentException("Member not found"));
        
        course.setMember(member);        
        return toDto(coursesRepository.save(course));//sending data to the front-end
	}
	
	//read
	@Override
	public CoursesDto getCourse(Long courseId) {
		Courses course = coursesRepository.findById(courseId)
				.orElseThrow(()-> new IllegalArgumentException("Course not found"));
		return toDto(course);
	}
	
	//read by memberId
	@Override
	public List<CoursesDto> getCoursesByMember(Long memberId){
		return coursesRepository.findByMember_MemberId(memberId)
				.stream().map(this::toDto)
				.collect(Collectors.toList());
	}
	
	//delete
	@Override
	public void deleteCourse(Long courseId) {
		coursesRepository.deleteById(courseId);
	}	
		
	//update
	public CoursesDto updateCourse(Long courseId, CourseRequestDto requestDto) {
        Courses course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
            course.setTitle(requestDto.getTitle());
            course.setContent(requestDto.getContent());
            course.setAreaCode(requestDto.getAreaCode());
            course.setSigunguCode(requestDto.getSigunguCode());
            return toDto(coursesRepository.save(course));
	}
	
	//top8 by time_crdttm
//	@Override
//	public List<CoursesDto> getTop8Courses(String sort){
//		List<Courses> courses;
//		Pageable top8 = PageRequest.of(0, 8);
//		courses = coursesRepository.findTop8CoursesWithMember(top8);
////		if("likes".equalsIgnoreCase(sort)) {
////			courses = CoursesRepository.findTopCoursesByLikes(top8);
//		if("recent".equalsIgnoreCase(sort)) {
//			courses = coursesRepository.findTop8ByOrderByCrdttmDesc();
//		}else {
//			throw new IllegalArgumentException("Unsupported sort option" + sort);
//		}	
//		return courses.stream().map(this::toDto).collect(Collectors.toList());
//	}
	
//		List<Courses> courses;
//		if ("populor".equals(sort)) {
//			courses = coursesRepository.findTop8ByOrderByLikesDesc(); // You need to define this
//		} else {
//		    courses = coursesRepository.findTop8ByOrderByLikesDesc(); // Or your time field
//		}	
//		
//		//get like counts
//	    Map<Long, Long> likeCountMap = courseLikesRepository
//	    		.countLikesPerCourse().stream()
//	            .collect(Collectors.toMap(CourseLikeCountDto::getCourseId, CourseLikeCountDto::getLikeCount));
//		
//		//build Dtos with like count
//		return courses.stream()
//				.map(course -> new CoursesDto(
//						course.getCourseId(),
//						course.getTitle(),
//						course.getCourseComments(),
//						course.getMember().getMemberId(),
//						likeCountMap.getOrDefault(course.getCourseId(),0L).intValue()
//				))
//				.collect(Collectors.toList());
	
	//top8 by like counts
	public List<CoursesDto> getTop8Courses(String sort) {
		
		List<Courses> topCourses = coursesRepository.findTop8ByOrderByCrdttmDesc();
		List<CoursesDto> result = new ArrayList<>();
		
		for (Courses course : topCourses) {
			int likeCount = courseLikesRepository.countByCourseId(course.getCourseId());
			
			CoursesDto dto = CoursesDto.builder()
	                .courseId(course.getCourseId())
	                .title(course.getTitle())
	                .content(course.getContent())
					.areaCode(course.getAreaCode())
					.sigunguCode(course.getSigunguCode())
					.crdttm(course.getCrdttm())
					.member(toMemberDto(course.getMember())) // ⬅️ convert Member entity to DTO
					.likeCount(likeCount)
//					.likeCount(course.getLikeCount())
	                .build();
			result.add(dto);
		}
		
		return result;
	}
		
	
	//convert entity Courses to object CoursesDto
	private CoursesDto toDto(Courses course) {
		return CoursesDto.builder()
				.courseId(course.getCourseId())
				.title(course.getTitle())
				.content(course.getContent())
				.areaCode(course.getAreaCode())
				.sigunguCode(course.getSigunguCode())
				.crdttm(course.getCrdttm())
				.member(toMemberDto(course.getMember())) // ⬅️ convert Member entity to DTO
//		        .likeCount(course.getLikeCount())
//				.likeCount(likeCount)
				.build();
	}
	
	private MembersDto toMemberDto(Members member) {
		return MembersDto.builder()
				.memberId(member.getMemberId())
				.nickname(member.getNickname())
		        // add more fields if needed
				.build();
	}
}





