package com.app.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 필드만 추가하면 getter, setter 자동으로 추가
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor	// parameter 없는 생성자
//@AllArgsConstructor	// 모든 parameter 생성자

@Data
@ToString
public class Room {

	int roomId;	//Primary Key 기본키 식별자
	String buildingNumber;	//동 이름	A동 B동
	int roomNumber;	//호실번호 101 405
	int floor;	//층
	int maxGuestCount;	//최대 숙박 인원
	String viewType;	// OCN / CTY / MOT
						// 오션 /	 시티 / 마운틴
}
