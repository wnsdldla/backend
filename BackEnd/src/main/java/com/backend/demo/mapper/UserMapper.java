package com.backend.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.backend.demo.VO.UserVO;


@Repository
public interface UserMapper {

	/* 기존
	UserVO selectUserByNumber(long userNumber);
	List<UserVO> selectAllUsers();
	void insertUser(UserVO user);
	*/
	//02.17수정
	//유저 정보
	ArrayList<UserVO> findByUserId(@Param("userId") String userId);
	
	//유저 저장
	int userSave(UserVO userVO);
	
	//유저 권한 저장
	int userRoleSave(@Param("userNo") int userNo, @Param("roleNo") int roleNo);
	
	//유저 fk번호 알아내기
	int findUserNo(@Param("userId") String userId);
	
	//권한 fk 번호 알아내기
	int findRoleNo(@Param("roleName") String roleName);
	
	//02.18 수정
	
	
}
