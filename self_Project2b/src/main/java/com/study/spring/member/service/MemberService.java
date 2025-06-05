package com.study.spring.member.service;

import java.util.List;

import com.study.spring.member.dto.MemberRequestDto;
import com.study.spring.member.dto.MembersDto;
import com.study.spring.member.entity.Members;

public interface MemberService {
	MembersDto getMember(Long memberId);
	MembersDto createMember(MemberRequestDto requestDto);
	List<MembersDto> getAllMembers();
	
	MembersDto updateMember(Long memberId, MembersDto dto);
	void deleteMember(Long memberId);

}
