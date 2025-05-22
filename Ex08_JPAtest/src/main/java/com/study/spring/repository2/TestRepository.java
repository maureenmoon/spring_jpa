package com.study.spring.repository2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.entity2.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
