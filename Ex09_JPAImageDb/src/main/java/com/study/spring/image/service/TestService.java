package com.study.spring.image.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.study.spring.image.dto.TestDto;
import com.study.spring.image.dto.TestResponseDto;
import com.study.spring.image.dto.TestUpdateDto;
import com.study.spring.image.entity.TestEntity;
import com.study.spring.image.entity.TestImage;
import com.study.spring.image.repository.TestRepository;
import com.study.spring.util.CustomfileUtil;
import lombok.extern.log4j.Log4j2;
 
@Service
@Log4j2
public class TestService {

	@Autowired
	public TestRepository testRepository;
	
	@Autowired
	private CustomfileUtil fileUtil;

	//4. ready to put into DB : dto → entity(=DB저장)
	public void testInsert(TestDto dto) {	
//		TestEntity test = new TestEntity();
//		test.setName(dto.getName());
//		test.setTitle(dto.getTitle());
		
		TestEntity test = TestEntity.builder()
				.title(dto.getTitle())
				.name(dto.getName())
				.content(dto.getContent())
				.build();
	
		List<String> uploadedFileNames = dto.getUploadFileNames();
		
		if(uploadedFileNames != null) {
			for(String fileName:uploadedFileNames) {
				test.addImageString(fileName);
				log.info("------------- file name ---------------" + fileName);	
			}
		}
		//5. save into DB
		testRepository.save(test);
		
	}
//  예전방식	
//	public List<TestResponseDto> getList() {
//		List<TestEntity> tests = testRepository.findAll();	
//		List<TestResponseDto> resultList = new ArrayList<>();
//		
//		for(TestEntity test:tests) {
//			List<String> imageNames = new ArrayList<>();
//			
//			for(TestImage image:test.getImageList()) {
//				imageNames.add(image.getStoredName());
//			}
//			TestResponseDto dto = new TestResponseDto(
//					test.getId(),
//					test.getName(),
//					test.getTitle(),
//					test.getContent(),
//					imageNames
//					);		
//			resultList.add(dto);
//		}		
//		return resultList;
//	}
	
	//search : img 가져옴
	//TestEntity->TestResponseDto
	//최근방식
	public List<TestResponseDto> getList() {
		List<TestEntity> tests = testRepository.findAll();
		//List<> resultList = tests.stream().map().toList()
		List<TestResponseDto> resultList = tests.stream()
				.map(test->{
					List<String> imageNames = test.getImageList().stream()
							.map(TestImage::getStoredName)
							.toList();
					return new TestResponseDto(
							test.getId(),
							test.getName(),
							test.getTitle(),
							test.getContent(),
							imageNames
							);
				})
				.toList();
		return resultList;
	}
	
	// pagination 아래에 더 간편한 방식 있음
	public Page<TestResponseDto> getList(Pageable pageable) {
		Page<TestEntity> tests = testRepository.findAll(pageable);
		Page<TestResponseDto> resultList = tests
				.map(test->{
					List<String> imageNames = test.getImageList().stream()
							.map(TestImage::getStoredName)
							.toList();
					return new TestResponseDto(
							test.getId(),
							test.getName(),
							test.getTitle(),
							test.getContent(),
							imageNames
							);
				});
		return resultList;
	
	//간편한방식
//	public Page<TestResponseDto> getList(Pageable pageable) {
//	return testRepository.findAll(pageable)
//							.map(test->{
//								List<String> imageNames = test.getImageList().stream()
//									.map(TestImage::getStoreName)	
//									.toList();
//					return new TestResponseDto(
//							test.getId(),
//							test.getName(),
//							test.getTitle(),
//							test.getContent(),
//							imageNames
//							);
//				});
	
	}	
	
	//read one file
	public TestResponseDto getbyId(Long id) {
		TestEntity test = testRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found"));
		List<String> imageNames = test.getImageList().stream()
				.map(TestImage::getStoredName).toList();	
		return new TestResponseDto(
				test.getId(),
				test.getName(),
				test.getTitle(),
				test.getContent(),
				imageNames);
	}
	
	//delete one img
	public boolean testDelete(Long id) {
		Optional<TestEntity> testId = testRepository.findById(id);
		if(testId.isPresent()) {
			TestEntity test = testId.get();
			log.info("--------------id----------------" + id);
			
			List<String> storedNames = test.getImageList().stream()
					.map(TestImage::getStoredName)
					.toList();
			fileUtil.deleteFiles(storedNames);
			
			testRepository.delete(test);
			return true;
		}else {
			return false;
		}	
	}
  
	//update : 기존화일이름/수정화일/차이나는 부분 DB에서 삭제
	public void updateTest(Long id, TestUpdateDto dto) {
		TestEntity test = testRepository.findByIdWithImages(id).orElseThrow();
		test.setTitle(dto.getTitle());
		test.setContent(dto.getContent());
		test.setName(dto.getName());
		
		log.info("original image list", test.getImageList().size());
		test.getImageList().forEach(img -> log.info(" - {}", img.getStoredName()));
		
		//기존 DB에 저장된 화일이름 찾기
		List<String> currentDBFiles = test.getImageList().stream()
				.map(TestImage::getStoredName)
				.toList();
		//수정화일
		List<String> updatedFileName = dto.getUpdatedFileNames();//최종화일
		
		//기존화일과 수정화일 차이나는 부분 DB에서 삭제
		List<String> toDelete = currentDBFiles.stream()
				.filter(oldName -> !updatedFileName.contains(oldName))
				.toList();
		
		test.getImageList().removeIf(img -> toDelete.contains(img.getStoredName()));
		fileUtil.deleteFiles(toDelete);
		if(dto.getNewUploadedFileNames() != null) {
			for(String fileName:dto.getNewUploadedFileNames()) {
				test.addImageString(fileName);
			}
		}
		
		testRepository.save(test);
		
	}
	
	
	
}
