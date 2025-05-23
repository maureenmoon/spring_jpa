package com.study.spring.postsComment;

import java.time.LocalDateTime;

import com.study.spring.posts.EPosts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//request, response DTO 클래스를 하나로 묶어 InnerStaticClass로 한 번에 관리
public class DPostsComment {
	
	//댓글 서비스 request
	@Data
	@NoArgsConstructor
	@AllArgsConstructor	
	public static class Request {
	    
		private String content;//댓글내용
		private String writer;		

		//Dto -> Entity
		public EPostsComment toEntity(EPosts post) {
			return EPostsComment.builder()
					.content(content)
					.writer(writer)
					.posts(post)
					.build();			
		}
	}	
	
	//댓글정보 리턴할 response
	//엔티티를 생성자 파라미터로 받아 데이터를 Dto로 변환하여 응답
	//별도의 전달객체를 활용해 연관관계를 맺은 엔티티간 무한참조 방지
	@Getter
	@AllArgsConstructor
	public static class Response{
	    private final Long id;	    
//	    private final  String title;
	    private final  String content;
	    private final  String writer;		
		private final  LocalDateTime crdttm;	
//		private final  Long userId;
//		private final Long postsId;
		
		//Entity ->Dto	
		public Response(EPostsComment postsComment) {
			this.id = postsComment.getId();
			this.content=postsComment.getContent();
			this.writer=postsComment.getWriter();
			this.crdttm=postsComment.getCrdttm();
		}
	}
}
