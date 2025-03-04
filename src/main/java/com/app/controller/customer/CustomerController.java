package com.app.controller.customer;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.file.FileInfo;
import com.app.dto.user.ProfileRequestForm;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.dto.user.UserProfileImage;
import com.app.dto.user.UserValidError;
import com.app.service.file.FileService;
import com.app.service.user.UserService;
import com.app.util.FileManager;
import com.app.util.LoginManager;
import com.app.util.SHA256Encryptor;
import com.app.validator.UserCustomValidator;
import com.app.validator.UserValidator;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileService;
	
	//회원가입
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signUpAction(/*@Valid*/ @ModelAttribute User user, BindingResult br, Model model) {
		
		//별도로 생성한 UserValidError 객체 사용하는 케이스
		UserValidError userValidError = new UserValidError();
		boolean validResult = UserCustomValidator.validate(user, userValidError);
		
		if( !validResult ) {
			//유효성 검증 통과 실패
			//저장 진행하지 말고 다시 가입페이지로 이동
			model.addAttribute("userValidError", userValidError);
			
			return "customer/signup";
		}
		
		
		
		/*
		//BindingResult (Errors) 사용하는 케이스
		//유효성 검증
		UserCustomValidator.validate(user, br);
		
		//유효성 검증 성공여부
		if( br.hasErrors() ) {
			List<ObjectError> errorList = br.getAllErrors();
			for(ObjectError er : errorList) {
				System.out.println(er.getObjectName());
				System.out.println(er.getDefaultMessage());
				System.out.println(er.getCode());
				System.out.println(er.getCodes()[0]);
			}
			
			return "customer/signup";
		}
		*/
		
		//client -> request ->userRequestForm
		//userRequestForm -> user 변환
		//saveUser(user)
		
		
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		String encPw;
		try {
			//사용자 비밀번호 암호화 처리
			encPw = SHA256Encryptor.encrypt(user.getPw());
			user.setPw(encPw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		int result = userService.saveUser(user);	//DB에 유저정보 저장
		
		if( result > 0 ) {
			return "main"; 
		} else {
			return "customer/signup";
		}
	}
	
	
	@InitBinder("user")
	public void initUserBinder(WebDataBinder binder) {
		UserValidator validator = new UserValidator();
		//binder.setValidator(validator);
		binder.addValidators(validator);
	}
	
	
	@ResponseBody
	@RequestMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		
		//...
		System.out.println("customer/checkDupId 요청 들어옴");
		System.out.println(data);
		
		//매개변수 data : 중복여부를 확인하고 싶은 아이디
		
		//id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(data); //비교할 id
		
		if(result) { 
			return "Y";	//중복O -> Y
		} else {
			return "N";	//중복X -> N
		}
		
		//return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
		
		//...
		System.out.println("customer/checkDupId 요청 들어옴");
		System.out.println(userDupCheck);	//data : JSON Format Text -> parse (json-simple, Jackson)
		
		//매개변수 data : 중복여부를 확인하고 싶은 아이디
		
		//id 중복 여부 체크 -> 결과 return
		boolean result = userService.isDuplicatedId(userDupCheck.getId()); //비교할 id
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		apiResponse.setHeader(header);
		
		if(result) { 
			apiResponse.setBody("Y");	//중복O -> Y
		} else {
			apiResponse.setBody("N");	//중복X -> N
		}
		
		return apiResponse;
	}
	
	
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		
		//user	id, pw 화면으로부터 전달
		// name, userType : null
		
		//user 로그인 할 수 있게 정보가 들어있는지 확인
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		try {
			user.setPw(SHA256Encryptor.encrypt(user.getPw()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		User loginUser = userService.checkUserLogin(user);
		
		if( loginUser == null ) {
			return "customer/login";
		} else {
			//로그인 정보가 맞아서 로그인 성공
			//session.setAttribute("loginUser", loginUser);
			//session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLogin(session, loginUser.getId());
			
			return "redirect:/main";
		}
	}
	
	@GetMapping("customer/logout")
	public String logout(HttpSession session) {
		//session.invalidate();
		LoginManager.logout(session);
		
		return "redirect:/main";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		
		//session에 loginUserId 값의 존재유무
		//if( session.getAttribute("loginUserId") != null ) {
		if( LoginManager.isLogin(session) ) {
			//로그인 되어 있는 정보를 보여주기
			//User user = userService.findUserById((String) session.getAttribute("loginUserId"));
			User user = userService.findUserById(LoginManager.getLoginUserId(session));
			model.addAttribute("user", user);
			
			//userid -> UserProfileImage -> (fileName) -> FileInfo
			
			UserProfileImage upi = userService.findUserProfileImageById(user.getId());
			
			if( upi != null ) {
				FileInfo fileInfo = fileService.findFileInfoByFileName(upi.getFileName());
				model.addAttribute("fileInfo", fileInfo);
			}
			
			return "customer/mypage";
		} else {
			return "redirect:/customer/login";
		}
	}
	
	/*
	@PostMapping("/customer/profile")
	public String profileAction(HttpServletRequest request, 
			MultipartRequest multipartRequest) {
		
		System.out.println( request.getParameter("id") );
		System.out.println( request.getParameter("name") );
		
		MultipartFile file = multipartRequest.getFile("profileImage");
		
		System.out.println( file.getName() );
		System.out.println( file.getOriginalFilename() );
		System.out.println( file.isEmpty() );
		System.out.println( file.getContentType() );
		System.out.println( file.getSize() );
		
		return "redirect:/customer/mypage";
	}
	*/
	
	
	@PostMapping("/customer/profile")
	public String profileAction(ProfileRequestForm profileRequestForm) {
		
		System.out.println( profileRequestForm.getId() );
		System.out.println( profileRequestForm.getName() );
		
		MultipartFile file = profileRequestForm.getProfileImage();
		
		//첨부파일 수신
		System.out.println( file.getName() );
		System.out.println( file.getOriginalFilename() );
		System.out.println( file.isEmpty() );
		System.out.println( file.getContentType() );
		System.out.println( file.getSize() );
		
		//1. 실제 파일을 폴더에 저장
		/*
		// 1)자체 저장
		try {
			file.transferTo( new File("e:/fileStorage/" + file.getOriginalFilename()) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// 2)FileManager 활용
		try {
			//실제 폴더에 파일을 저장
			FileInfo fileInfo = FileManager.storeFile(file);
		
		//2. 파일 정보를 DB에 저장
			//파일 정보만 DB에 저장
			int result = fileService.saveFileInfo(fileInfo);
			
			if( result > 0 ) {
				//log.info(fileInfo.getFileName() + "파일 저장 잘됨");
				
				//UserProfileImage 에도 연결할 수 있게 저장
				
				UserProfileImage upi = new UserProfileImage();
				//userid를 어디서 가져오나?
				//1) 세션
				//2) view에 hidden으로 저장된 id를 같이 전송
				upi.setId(profileRequestForm.getId());		//사용자id
				upi.setFileName(fileInfo.getFileName());	//파일name
				
				int result2 = userService.saveUserProfileImage(upi);
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		

		
		return "redirect:/customer/mypage";
	}
	
	
}
