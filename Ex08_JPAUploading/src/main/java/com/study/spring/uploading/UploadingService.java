package com.study.spring.uploading;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadingService {
	
	@Autowired
	public UploadingRepository uploadingRepository;
	
	//folder setting
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	public void uploadingCreate(UploadingDto uploadingDto) {
		
	UploadingEntity createData = new UploadingEntity();
	
	createData.setName(uploadingDto.getName());
	createData.setTitle(uploadingDto.getTitle());
	createData.setContent(uploadingDto.getContent());
	createData.setStartdate(LocalDateTime.now());
	
	MultipartFile fileImg = uploadingDto.getFiles();
	if(fileImg !=null && !fileImg.isEmpty() ) {
		System.out.println(fileImg.getOriginalFilename());
		
		try {
	//1. create directory
			File folder = new File(uploadDir);
			if(!folder.exists()) {
				folder.mkdir();
			}
	//2. file-name/UUID
			String originalName = fileImg.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			String extension = originalName.substring(originalName.lastIndexOf("."));
			String storeFileName = uuid + extension;
			System.out.println("file-name : " + storeFileName);
			
	//3. save the original file
			//MultipartFile.transferTo() : 업로드된 파일을 서버의 지정된 위치로 저장
			//파일데이터를 메모리에 로드하지않고, 직접 디스트로 전송하여 대용량 파일처리에 효율적 
			File originFile = new File(uploadDir + File.separator + storeFileName);
			fileImg.transferTo(originFile);
			
	//4. createData		
			createData.setUploadingFileNames(storeFileName);
			} catch (Exception e) {
			  }	
		} else {
			System.out.println("no files");
		}
	System.out.println("entity : " + createData.toString());
		
	//5. save it into DB
	uploadingRepository.save(createData);
	}
}
