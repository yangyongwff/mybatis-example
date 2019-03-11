package tk.mybatis.simple.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable {
	
	private Long id;
	private String userName;
	private String usePassword;
	private String userEmail;
	private String userInfo;
	private byte[] headImg;
	private Date createTime;
	private SysRole role;
	private List<SysRole> roleList;
	
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	public String getUsePassword() {
		return usePassword;
	}
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return usePassword;
	}
	public void setUserPassword(String userPassword) {
		this.usePassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public byte[] getHeadImg() {
		return headImg;
	}
	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
