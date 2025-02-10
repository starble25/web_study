package com.app.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
//	public static final String USERTYPE_CUSTOMER = "CUS";
//	public static final String USERTYPE_ADMIN = "ADM";

//	@NotBlank(message = "필수 입력")
	String id;
	
//	@NotBlank
//	@Size(min = 8, max = 12, message="8자리 이상, 12자리 이하")
	String pw;
	
//	@Email
	String name;
	String userType;	// CUS(Customer)	ADM(Admin)
	
}
