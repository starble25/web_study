package com.app.common;

public interface ApiCommonCode {
	String API_RESULT_SUCCESS = "10";
	String API_RESULT_TEMP_ERROR = "20";
	String API_RESULT_FAIL_AUTH = "30";
	String API_RESULT_NO_DATA = "40";
	
	String API_RESULT_SUCCESS_MSG = "정상";
	String API_RESULT_TEMP_ERROR_MSG = "일시적인 문제";
	String API_RESULT_FAIL_AUTH_MSG = "인증불가";
	String API_RESULT_NO_DATA_MSG = "데이터 없음";
	
	//10 정상
	//20 일시적인 문제
	//30 인증불가
	//40 데이터 없음
}
