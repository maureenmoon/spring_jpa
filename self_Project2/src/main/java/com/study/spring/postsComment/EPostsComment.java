package com.study.spring.postsComment;

import java.time.LocalDateTime;

import com.study.spring.posts.EPosts;
import com.study.spring.user.EUser;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EPostsComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;//댓글내용
	private String writer;
	
	private LocalDateTime crdttm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private EUser user; //작성자
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private EPosts posts; 

}
