package com.study.spring.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.study.spring.course.dto.CourseRequestDto;
import com.study.spring.course.dto.CoursesDto;
import com.study.spring.course.entity.Courses;
import com.study.spring.member.entity.Members;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
	

    List<Courses> findByMember_MemberId(Long memberId);
	
	@Query("SELECT c FROM Courses c LEFT JOIN c.courseLikes l GROUP BY c ORDER BY COUNT(l) DESC")
	List<Courses> findTop8CoursesWithMember(Pageable pageable);
	
    // Top 8 most recent courses
	@EntityGraph(attributePaths = "member")
	List<Courses> findTop8ByOrderByCrdttmDesc();
	
//	List<Courses> findTop8ByOrderByLikesDesc(); //approach in service layer only
	
    // Top 8 courses by number of likes using native query or JPQL
    @Query("SELECT c FROM Courses c LEFT JOIN c.courseLikes cl GROUP BY c ORDER BY COUNT(cl) DESC, c.crdttm DESC")
    List<Courses> findTop8ByLikes(Pageable pageable);

	


	
}
