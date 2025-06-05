package com.study.spring.course.dto;

import java.time.LocalDateTime;

import com.study.spring.member.dto.MemberRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// separating requet and response DTOs prevents exposing sensitive or unwanted data(password)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDto {
    private String title;
    private String content;
    private String areaCode;
    private String sigunguCode;
    private Long memberId; //needed to associate the course with a member


}
