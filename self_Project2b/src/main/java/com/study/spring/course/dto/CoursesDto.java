package com.study.spring.course.dto;

import java.time.LocalDateTime;

import com.study.spring.member.dto.MembersDto;
import com.study.spring.member.entity.Members;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursesDto {
    private Long courseId;
    private String title;
    private String content;
    private String areaCode;
    private String sigunguCode;
    private LocalDateTime crdttm;
    
//    private Long memberId;          //why not using private Member member?
//    private String memberNickname;  //why not using private Member member?
    
    private MembersDto member;// instead of memberId + nickname
  
    private int likeCount;
    
    
}
