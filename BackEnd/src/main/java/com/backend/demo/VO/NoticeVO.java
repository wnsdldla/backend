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
public class NoticeVO implements Serializable{
	//02.18 추가
	private int noticeNum;
	private String noticeTitle;
	private String noticeContents;
	private String noticeDate;
	
	private String adminEmail;
	private int readCount;
	
	public int getNoticeNum() {return noticeNum;}
	public void setNoticeNum(int noticeNum) {this.noticeNum = noticeNum;	}
	
	public String getNoticeTitle() {return noticeTitle;	}
	public void setNoticeTitle(String noticeTitle) {this.noticeTitle = noticeTitle;	}
	
	public String getNoticeContents() {return noticeContents;	}
	public void setNoticeContents(String noticeContents) {this.noticeContents = noticeContents;	}
	
	public String getNoticeDate() {return noticeDate;	}
	public void setNoticeDate(String noticeDate) {this.noticeDate = noticeDate;	}
	
	public String getAdminEmail() {return adminEmail;	}
	public void setAdminEmail(String adminEmail) {this.adminEmail = adminEmail;	}
	
	public int getReadCount() {return readCount;	}
	public void setReadCount(int readCount) {this.readCount = readCount;	}
	
	@Override
	public String toString() {
		return "NoticeVO [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeContents=" + noticeContents
				+ ", noticeDate=" + noticeDate + ", adminEmail=" + adminEmail + ", readCount=" + readCount + "]";
	}
	
	
	

	
	
}
