package com.study.spring.member.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.member.dto.MemberRequestDto;
import com.study.spring.member.dto.MembersDto;
import com.study.spring.member.entity.Members;
import com.study.spring.member.repository.MembersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MembersRepository membersRepository;
	
	//create
	@Override
	public MembersDto createMember(MemberRequestDto requestDto) {
		Members member = new Members();
		
		member.setEmail(requestDto.getEmail());
        member.setPassword(requestDto.getPassword()); // later encrypt
        member.setNickname(requestDto.getNickname());
        member.setProfileImg(requestDto.getProfileImg());
        member.setAuthGrade("USER");
        member.setCrdttm(LocalDateTime.now());
        
        membersRepository.save(member);
        
        return toDto(member);
	}

	//convert entity Members to object MembersDto
	private MembersDto toDto(Members member) {
		MembersDto dto = new MembersDto();
		
		dto.setMemberId(member.getMemberId());
        dto.setEmail(member.getEmail());
        dto.setNickname(member.getNickname());
        dto.setProfileImg(member.getProfileImg());
        dto.setAuthGrade(member.getAuthGrade());
        dto.setCrdttm(member.getCrdttm());
        return dto;		
	}
	
	//read
	@Override
	public MembersDto getMember(Long memberId) {
		Members member = membersRepository.findById(memberId)
				.orElseThrow(() -> new IllegalArgumentException("Member not found"));
		return toDto(member);
	}

	//get all members
	@Override
	public List<MembersDto> getAllMembers(){
		return membersRepository.findAll()
				.stream().map(this::toDto)
				.collect(Collectors.toList());
		}
	
	//update
	@Override
	@Transactional
	public MembersDto updateMember(Long memberId, MembersDto dto) {
		//1.find member fr DB
		Members member = membersRepository.findById(memberId)
				.orElseThrow(()-> new IllegalArgumentException("Member not found"));
		
		//2.only update fields that are not null in Dto
		if (dto.getEmail() !=null) {
			member.setEmail(dto.getEmail());
		}
		if (dto.getPassword() != null) {
			member.setPassword(dto.getPassword());
		}
		if (dto.getNickname() != null) {
			member.setNickname(dto.getNickname());
		}
		if (dto.getProfileImg() != null) {
			member.setProfileImg(dto.getProfileImg());
		}
		if (dto.getAuthGrade() !=null) {
			member.setAuthGrade(dto.getAuthGrade());
		}
		
		//3. save and return the updated member
		Members updated = membersRepository.save(member);
		return toDto(updated);
	}
	
	
	//delete	
	@Override
	public void deleteMember(Long memberId) {
		Members member = membersRepository.findById(memberId)
				.orElseThrow(()-> new IllegalArgumentException("Member not found"));
		membersRepository.delete(member);
	}
	
//    public void deleteMember(Long memberId) {
//        membersRepository.deleteById(memberId);
//    }


}






