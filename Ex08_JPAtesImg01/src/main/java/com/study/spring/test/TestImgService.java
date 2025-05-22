package com.study.spring.test;


import java.io.File;
import java.time.LocalDateTime;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class TestImgService {
	
	@Autowired
	public TestImgRepository testImgRepository;
	
	// folder setting
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	public void testImgCreate(TestImgDto testImgDto) {
		TestImgEntity createData = new TestImgEntity();
		createData.setName(testImgDto.getName());
		createData.setTitle(testImgDto.getTitle());
		createData.setContent(testImgDto.getContent());
		createData.setStartdate(LocalDateTime.now());
		
		MultipartFile fileImg = testImgDto.getFiles();	
		if(fileImg !=null && !fileImg.isEmpty()) {
			System.out.println("file name : " +fileImg.getOriginalFilename());
			System.out.println("file size : " + fileImg.getSize());
			System.out.println("file type : " + fileImg.getContentType());
			
			try {
				//1. create directory
				File folder = new File(uploadDir);
				if(!folder.exists()) {
					folder.mkdir();
				}
				//2. file name : UUID 생성되는 화일이름 다르게하기
				String originalName = fileImg.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				String extension = originalName.substring(originalName.lastIndexOf("."));
				String storeFileName = uuid + extension;
				String thumbnailFileName = "thumb_" + uuid + extension;
				
				System.out.println("file-name : " + storeFileName);		
				
				//3. save the original file
				File originFile = new File(uploadDir + File.separator + storeFileName);
				fileImg.transferTo(originFile);
				
				//4-1.save a thumbnail image : capa optimization
				File thumbnailFile = new File(uploadDir + File.separator + thumbnailFileName);
				Thumbnails.of(originFile).size(150,150).toFile(thumbnailFile);
				
				//4-2. ready to put createData to DB 
				createData.setImageFileNames(storeFileName);
				
			}catch (Exception e){	
			}			
		}else {
			System.out.println("no files");
		}
		System.out.println("entity : " +createData.toString());		
		
		//5.save DB 
		testImgRepository.save(createData);
		}

	public Page<TestImgEntity> findAll(Pageable pageable) {
		
		return testImgRepository.findAll(pageable);
	}


}
