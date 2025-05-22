package com.study.spring.selftest;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ServiceSelfJPA {
	
	@Autowired
	public RepositorySelfJPA repositorySelfJPA;
	
	//set the uploading dir
	@Value("${file.upload-dir}")
	private String uploadDir2;
	
	public void uploadingCreate(DtoSelfJPA dtoSelfJPA) {
		EntitySelfJPA createData = new EntitySelfJPA();
		
		createData.setTitle(dtoSelfJPA.getTitle());
		createData.setName(dtoSelfJPA.getName());
		createData.setContent(dtoSelfJPA.getContent());
		createData.setStartdate(LocalDateTime.now());
		createData.setLatitude(dtoSelfJPA.getLatitude());
		createData.setLongitude(dtoSelfJPA.getLongitude());
		
		MultipartFile fileImage = dtoSelfJPA.getFiles();
		if(fileImage !=null && !fileImage.isEmpty()) {
			System.out.println(fileImage.getOriginalFilename());
			
			try {
				//1. create dir
				File folder = new File(uploadDir2);
				if(!folder.exists()) {
					folder.mkdir();
				}
				
				//2. separate file names
				String originalName = fileImage.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				String extension = originalName.substring(originalName.lastIndexOf("."));
				String storeFileName = uuid + extension;
				System.out.println("file-name : " + storeFileName);
				
				String thumbnailFileName = "thumb_"+uuid+extension;
				
				//3. save the original file
				File originFile = new File(uploadDir2 + File.separator + storeFileName);
				fileImage.transferTo(originFile);
				
				//4. save a thumbnail img
				File thumbnailFile = new File(uploadDir2 + File.separator + thumbnailFileName);
				Thumbnails.of(originFile).size(150,150).toFile(thumbnailFile);
				
//		5. ready to put createData to DB
				createData.setSelfFileNames(storeFileName);
			} catch (Exception e) {
				}
			} else {
				System.out.println("no files");
			}
		System.out.println("entity : " + createData.toString());
				
		//6. save DB
		repositorySelfJPA.save(createData);
	}

	public Page<EntitySelfJPA> findAll(Pageable pageable) {
	
		return repositorySelfJPA.findAll(pageable);
	}
	
	
}
