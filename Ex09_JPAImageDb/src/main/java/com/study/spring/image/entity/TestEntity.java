package com.study.spring.image.entity;

import java.util.ArrayList;
import java.util.List;
import com.study.spring.member.entity.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String title;
	private String content;

	//게시글 vs.사용자 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	
	//게시글 vs.image화일
	@OneToMany(mappedBy = "testEntity", cascade = CascadeType.ALL,orphanRemoval = true)
	@OrderBy("ord ASC")
	@Builder.Default
	private List<TestImage> imageList = new ArrayList<>();
	
	//image 화일
	public void addImageString(String fileName) {
//		TestImage image = new TestImage();
//		image.setStoredName(fileName);
		
		TestImage  image = TestImage.builder()
				.storedName(fileName)
				.ord(imageList.size())
				.testEntity(this)
				.build();
		
		imageList.add(image);
	}
}
