package com.ezen.phonefly2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMobileDao;

@Service
public class MobileService {

	//MobileService 클래스는 IMobileDao 인터페이스를 주입받아 사용하는 형태
	@Autowired
	IMobileDao mdao; 

}
