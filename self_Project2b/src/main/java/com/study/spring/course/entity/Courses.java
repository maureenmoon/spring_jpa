package com.study.spring.course.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class Courses {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String title;
    private String content;
    private String areaCode;
    private String sigunguCode;

    private LocalDateTime crdttm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Members member;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseLikes> courseLikes = new ArrayList<>();
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseComments> courseComments = new ArrayList<>();

//    public int getLikeCount() {
//        return courseLikes != null ? courseLikes.size() : 0;
//    }
}
