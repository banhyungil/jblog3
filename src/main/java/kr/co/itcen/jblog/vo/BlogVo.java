package kr.co.itcen.jblog.vo;

public class BlogVo {
	String userId;
	String title;
	String logo;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "BlogVo [userId=" + userId + ", title=" + title + ", logo=" + logo + "]";
	}
	
	
}
