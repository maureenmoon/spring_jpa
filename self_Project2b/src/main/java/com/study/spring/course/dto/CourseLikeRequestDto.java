package com.study.spring.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseLikeRequestDto {
	private Long courseId;
	private Long memberId;//frt에서 사용되므로, 여기에 정보 요청하는 것이 편리하다

}
