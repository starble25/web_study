package com.app.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

//Data 읽어오는 역할 DB접근역할	DAO, Repository
// APIServiceRepository
@Repository	//Bean 등록 Annotation
public class RoomDAOImpl implements RoomDAO {

	@Override
	public List<Room> findRoomList() {

		System.out.println("RoomDAO 호출 됨");
		
		return null;
	}

	@Override
	public int saveRoom(Room room) {
		// TODO Auto-generated method stub
		// DB에 전달받은 Room 객체에 들어있는 데이터를 저장
		return 0;
	}
	
}
