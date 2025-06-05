package com.study.spring.member.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "memberRoleList")
//@ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	private String nickname;
	private boolean social; //외부 사이트(카카오,네이버 등) 로그인여부 확인

	// 꼭 같이 다녀할 것에 사용 : member vs memberRole
	@ElementCollection(fetch = FetchType.LAZY)
	@Builder.Default
	private List<MemberRole> memberRoleList = new ArrayList<>();	
	//user, member, admin 3개로 한정 = enum[user, member, admin]
	//element collection 사용하면  join문 사용안해도 됨

	public void addRole(MemberRole memberRole) {
		memberRoleList.add(memberRole);
	}
		
	//password, nickname 변경
	

}
