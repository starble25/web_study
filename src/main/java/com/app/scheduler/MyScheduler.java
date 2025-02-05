package com.app.scheduler;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.dto.user.User;
import com.app.service.user.UserService;

public class MyScheduler {
	
	@Autowired
	UserService userService;

	@Scheduled(cron = "0/5 * * * * *")
//	@Scheduled(cron = "0 0 3 * * *")
	public void schedule() {
		System.out.println("schedule" + LocalDate.now());
		
		//api 요청
		
		//api 요청 데이터 DB 저장
		//apidata 테이블 -> insert 저장 (apidataDAO)
		
		User user = userService.findUserById("abc");
		System.out.println(user);
	}
}
