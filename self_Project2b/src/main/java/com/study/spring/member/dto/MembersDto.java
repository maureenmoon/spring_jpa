package com.study.spring.member.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembersDto {
    private Long memberId;
    private String email;
    @JsonIgnore //not to return the password in the API response
    private String password;
    private String nickname;
    private String profileImg;
    private String authGrade;
    private LocalDateTime crdttm;

}
