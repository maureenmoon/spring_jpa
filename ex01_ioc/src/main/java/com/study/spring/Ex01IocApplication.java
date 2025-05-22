package com.study.spring;



import com.study.spring.bin.BeanContainer;
//import com.study.spring.tv.LgTv;
//import com.study.spring.tv.SamsungTv;
import com.study.spring.tv.TV;

//@SpringBootApplication
public class Ex01IocApplication {

	static BeanContainer container = new BeanContainer();
	
	public static void main(String[] args) {
//		args사용하면 임의 데이터를 가져올 수 있다(lg, samsung)

		//		SpringApplication.run(Ex01IocApplication.class, args);
//		TV tv = new SamsungTv();
//		LgTv를 SamsungTv로 바꾸면 바로 실행:<==강한 결합
		
//		TV tv = new LgTv();
	
		TV tv = (TV)container.getBean(args[0]);
//		Run as Configurations : Ioc inversion of control 제어의 역전: 고정되지않음 <== 약한 결합
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
