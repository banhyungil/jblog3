package kr.co.itcen.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private String regDate;
	private String description;
	private String userId;
	private Long postCount;
	
	
	public Long getPostCount() {
		return postCount;
	}
	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", regDate=" + regDate + ", description=" + description
				+ ", userId=" + userId + "]";
	}
	
	
}
