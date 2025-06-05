package com.study.spring.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.spring.course.dto.CourseLikeCountDto;
import com.study.spring.course.dto.LikeCountProjection;
import com.study.spring.course.entity.CourseLikes;
import com.study.spring.course.entity.Courses;
import com.study.spring.member.entity.Members;

public interface CourseLikesRepository extends JpaRepository<CourseLikes, Long> {
	
	//test via Postman using /courses/top8?sort=recent or /courses/top8?sort=likes
	
    @Query("SELECT cl.course.id AS courseId, COUNT(cl) AS likeCount " +
            "FROM CourseLikes cl GROUP BY cl.course.id")
     List<LikeCountProjection> countLikesPerCourse();

    //count likes for a specific course
    @Query("SELECT COUNT(cl) FROM CourseLikes cl WHERE cl.course.courseId = :courseId")
//     int countByCourseId(Long courseId); //X missing @Raram
    int countByCourseId(@Param("courseId") Long courseId); 

	 int countByCourse(Courses course);//safe count

//	 @Query("SELECT cl FROM CourseLikes cl WHERE cl.course = :course AND cl.member = :member")
	 @Query("SELECT COUNT(cl) > 0 FROM CourseLikes cl WHERE cl.course = :course AND cl.member = :member")
//	 boolean existsByCourseAndMember(Courses course, Members member);//X missing @Raram
	 boolean existsByCourseAndMember(@Param("course") Courses course, @Param("member") Members member);

	Optional<CourseLikes> findByCourseAndMember(Courses course, Members member);
	 
//	 int likeCount = courseLikesRepository.countByCourse(course);
     
}
