package com.backend.demo.VO;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class UserVO implements Serializable{
/*	
	@NonNull private long userNumber;
	@NonNull private String userId;
	@NonNull private String password;
	@NonNull private String userName;
	@NonNull private String auth;
	@NonNull private int enabled;
	
	
	
	public UserVO() {;	}
	
	public UserVO(@NonNull long userNumber, @NonNull String userId, @NonNull String password, @NonNull String userName,
			@NonNull String auth, @NonNull int enabled) {
		super();
		this.userNumber = userNumber;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.auth = auth;
		this.enabled = enabled;
	}
	
	public long getUserNumber() {		return userNumber;	}
	public void setUserNumber(long userNumber) {		this.userNumber = userNumber;	}
	
	public String getUserId() {		return userId;	}
	public void setUserId(String userId) {		this.userId = userId;	}
	
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	
	public String getUserName() {		return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	
	public String getAuth() {		return auth;	}
	public void setAuth(String auth) {		this.auth = auth;	}
	
	public int getEnabled() {		return enabled;	}
	public void setEnabled(int enabled) {		this.enabled = enabled;	}
	
	@Override
	public String toString() {
		return "UserVO [userNumber=" + userNumber + ", userId=" + userId + ", password=" + password + ", userName="
				+ userName + ", auth=" + auth + ", enabled=" + enabled + "]";
	}
	*/
	//version 2.0(02.17)
	private int userNo;
	private String userId;
	private String password;
	private String name;
	
	private String roleName;

	public int getUserNo() {return userNo;}
	public void setUserNo(int userNo) {this.userNo = userNo;}
	
	public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getRoleName() {return roleName;}
	public void setRoleName(String roleName) {this.roleName = roleName;}
	
	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", password=" + password + ", name=" + name
				+ ", roleName=" + roleName + "]";
	}
	
}
