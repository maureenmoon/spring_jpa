package com.study.spring.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.member.dto.MemberRequestDto;
import com.study.spring.member.dto.MembersDto;
import com.study.spring.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
	
	
	private final MemberService memberService;
	
	
	
	//create
	@PostMapping
    public ResponseEntity<MembersDto> createMember(
    		@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(memberService.createMember(requestDto));
    }

	//read
    @GetMapping("/{id}")
    public ResponseEntity<MembersDto> getMember(
    		@PathVariable("id") Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    //list all members
    @GetMapping
    public ResponseEntity<List<MembersDto>> getAllMembers() {
    	List<MembersDto> members = memberService.getAllMembers();
    	return ResponseEntity.ok(members);
    }
    
    //update
    @PutMapping("/{id}")
    public ResponseEntity<MembersDto> updateMember(
    		@PathVariable("id") Long id,
    		@RequestBody MembersDto dto
    		){
    	return ResponseEntity.ok(memberService.updateMember(id, dto));
    }
      
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long id){
    	System.out.println(id);
    	
    	memberService.deleteMember(id);
    	return ResponseEntity.noContent().build(); //204 no content  	
    } 
}





