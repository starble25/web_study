package com.app.controller.study.quiz10.service;

import com.app.controller.study.quiz10.dto.Quiz10Customer;

public interface Quiz10CustomerService {
	
	//insert, update, delete된 행의 갯수 return
	public int saveCustomer(Quiz10Customer quiz10Customer);
}
