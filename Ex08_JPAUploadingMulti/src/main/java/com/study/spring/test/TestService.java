package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;

	//외부에서 가져올때는 ${}표기
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	public void testCreate(TestDto dto) throws IllegalStateException, IOException {
		
		File dir = new File(uploadDir);
		if(!dir.exists()) {
			dir.mkdir();
		}
//		System.out.println(dto.getFiles());
		List<String> savedFileNames = new ArrayList<>();
		
		if(dto.getFiles() != null && !dto.getFiles().isEmpty()) {
			for(MultipartFile file : dto.getFiles()){
				if(file != null && !file.isEmpty()) {
					try {
						//2.file name
						String originalName = file.getOriginalFilename();
						String uuid = UUID.randomUUID().toString();
						String extension = originalName.substring(originalName.lastIndexOf("."));
						String storeFileName = uuid + extension;
						String thumbnailFileName = "thumb_"+uuid+extension;  
						
						//2. upload files
						File saveFile = new File(uploadDir + storeFileName);
						//transferTo 에러날때 예외사항 처리추가
						file.transferTo(saveFile);
						
						File thumbnailFile = new File(uploadDir + thumbnailFileName);
						Thumbnails.of(saveFile).size(150, 150).toFile(thumbnailFile);
						
						//3. save the changed file name
						savedFileNames.add(storeFileName);
						
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("파일저장 또는 썸메일 생성 오류 발생");
					}
				}
			}
		}//if end
		System.out.println(savedFileNames.toString());
		
		TestEntity entity = new TestEntity();
		entity.setTitle(dto.getTitle());
		entity.setName(dto.getName());
		entity.setContent(dto.getContent());
		entity.setLocaldate(LocalDateTime.now());
		entity.setImageFileNames(String.join(",", savedFileNames));
		//5. save into DB
		testRepository.save(entity);
	}

//.map(entity -> new TestResponseDto(entity))
//	public List<TestResponseDto> findAll() {
//		return testRepository.findAll()
//				.stream()
//				.map(TestResponseDto::new) //.map(entity -> new TestRepositoryDto(entity))
//				.collect(Collectors.toList());
//	}

	public Page<TestResponseDto> findAll(Pageable pageable) {
		return testRepository.findAll(pageable)
				.map(TestResponseDto::new); 
	}

	public Page<TestResponseDto> findAll(String query, Pageable pageable) {
		
		return testRepository.findByTitleContainingIgnoreCase(query, pageable);
	}

	public Optional<TestEntity> findById(Long id) {
		
		return testRepository.findById(id);
	}

	//아이디 하나 삭제할때
	public boolean testDelete(Long id) {
		Optional<TestEntity> optional = testRepository.findById(id);
		
		if(optional.isPresent()) {
			TestEntity entity = optional.get();
			System.out.println(entity.toString());
			testRepository.deleteById(id);
			return true;
		} else {
			System.out.println("no data");
			return false;
		}		
	}

}
