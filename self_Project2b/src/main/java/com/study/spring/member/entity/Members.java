package com.study.spring.member.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.study.spring.course.entity.CourseComments;
import com.study.spring.course.entity.CourseLikes;
import com.study.spring.course.entity.Courses;
import com.study.spring.member.dto.MemberRequestDto;
import com.study.spring.member.entity.Members;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Members {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String email;
    private String password;
    private String nickname;
    private String profileImg;
    private String authGrade;

    private LocalDateTime crdttm;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Courses> courses = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseComments> courseComments = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseLikes> courseLikes = new ArrayList<>();
}
