package com.study.spring.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseLikeCountDto {
	private Long courseId;
	private Long likeCount;

}
