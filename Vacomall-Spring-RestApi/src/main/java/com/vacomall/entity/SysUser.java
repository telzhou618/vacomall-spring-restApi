package com.vacomall.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 *
 * 
 *
 */
@TableName("sys_user")
public class SysUser implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId(type = IdType.UUID)
	@ApiModelProperty("id")
	private String id;

	/** 用户名 */
	@NotEmpty(message = "用户名不能为空")
	@Length(min = 5, max = 20, message = "用户名长度为5-20之间")
	@Pattern(regexp = "[a-zA-Z]{5,20}", message = "用户名不合法")
	@ApiModelProperty("用户名")
	private String userName;

	/** 密码 */
	@NotBlank(message="密码不能为空")
	@Length(min = 5, max = 20, message = "密码长度为5-20之间")
	@ApiModelProperty("密码")
	private String password;

	/** 用户状态,1-启用,-1禁用 */
	private Integer userState;

	/** 创建时间 */
	private Date createTime;

	/** 描述 */
	private String userDesc;
	
	/** 头像 */
	private String userImg;
	
	/** 部门主键 */
	private String deptId;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	
}
