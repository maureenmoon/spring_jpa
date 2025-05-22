package com.study.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.entity.TestEntity;

//테이블이 여러개일때, sort by를 할 경우 query써야함
//	Page<TestEntity> findByTitleOrContentContaining(String query, String query,Pageable pageable);
//쿼리조건 추가하여 정확도 높임
@Repository
public interface TestRepository extends 
	JpaRepository<TestEntity, Long> {
	Page<TestEntity> findByTitleContaining(String query, Pageable pageable);
}
