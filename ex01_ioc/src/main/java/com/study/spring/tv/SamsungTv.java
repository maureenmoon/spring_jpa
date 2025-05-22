package com.study.spring.tv;

public class SamsungTv implements TV{
	public SamsungTv() {
		System.out.println("SamsungTv created");
	}

	@Override
	public void powerOn() {
		System.out.println("Power-on SamsungTv");
	}

	@Override
	public void powerOff() {
		System.out.println("Power-off SamsungTv");		
	}

	@Override
	public void volumeUp() {
		System.out.println("Volume-up SamsungTv");
	}

	@Override
	public void volumeDown() {		
		System.out.println("Volume-down SamsungTv");
		
	}

}
