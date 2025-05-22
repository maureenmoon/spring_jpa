package com.study.spring.bin;

import com.study.spring.tv.LgTv;
import com.study.spring.tv.SamsungTv;

public class BeanContainer {
	public Object getBean(String id) {
		if(id.equals("lg")) {
			return new LgTv();
	}else if(id.equals("samsung")) {
		return new SamsungTv();
	}
	return null;
}
}
