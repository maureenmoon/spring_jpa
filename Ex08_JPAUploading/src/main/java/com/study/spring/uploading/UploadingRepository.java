package com.study.spring.uploading;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadingRepository extends JpaRepository<UploadingEntity, Long> {

}
