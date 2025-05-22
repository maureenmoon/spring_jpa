package com.study.spring.user;

import java.time.LocalDateTime;
import com.study.spring.posts.EPosts;
import com.study.spring.postsComment.EPostsComment;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DUser {
	
	//회원  서비스  request
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor	
	public static class Request {
		
		private Long id;
		
//		@Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{2,10}$",message = "닉네임은 특수문자를 제외한 2~10자리 입니다")
//		@NotBlank(message = "닉네임은 필수 입력값입니다")
		private String nickname;
		
		private String email;
		private LocalDateTime crdttm;
		
//		private Role role;
		
		//Dto -> Entity
		public EUser toEntity() {
			EUser user = EUser.builder()
					.id(id)
					.nickname(nickname)
					.build();
			return user;
		}	
	}
	
//	  인증된 사용자 정보를 세션에 저장하기 위한 클래스
//    세션을 저장하기 위해 User 엔티티 클래스를 직접 사용하게 되면 직렬화를 해야 하는데,
//    엔티티 클래스에 직렬화를 넣어주면 추후에 다른 엔티티와 연관관계를 맺을시
//    직렬화 대상에 다른 엔티티까지 포함될 수 있어 성능 이슈 우려가 있기 때문에
//    세션 저장용 Dto 클래스 생성
	
//	@Getter
//	public static class Response 

}
