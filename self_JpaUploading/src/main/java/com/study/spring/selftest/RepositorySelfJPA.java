package com.study.spring.selftest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySelfJPA extends JpaRepository<EntitySelfJPA, Long>{
	

}
