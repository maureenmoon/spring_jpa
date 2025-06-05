package com.study.spring.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.member.entity.Members;


public interface MembersRepository extends JpaRepository<Members, Long> {
//	List<Members> findByMember_MemberId(Long memberId);
	List<Members> findByMemberId(Long memberId);
	
	//use JpaRepository for build-in CRUD
	//findByMember_MemberId to get all courses created by a user
	//Don't use memberNickname as the main key to fetch records
	//use memberId to fetch data, then include memberNickname in the response for display

}
