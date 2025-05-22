package com.study.spring.tv;

public class LgTv implements TV{
	public LgTv() {
		System.out.println("LgTv created");
	}

	@Override
	public void powerOn() {
		System.out.println("Power-on LgTv");
	}

	@Override
	public void powerOff() {
		System.out.println("Power-off LgTv");		
	}

	@Override
	public void volumeUp() {
		System.out.println("Volume-up LgTv");
	}

	@Override
	public void volumeDown() {		
		System.out.println("Volume-down LgTv");
		
	}

}
