package com.study.spring.member.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {

    private String email;
    private String password;
    private String nickname;
    private String profileImg;


}
