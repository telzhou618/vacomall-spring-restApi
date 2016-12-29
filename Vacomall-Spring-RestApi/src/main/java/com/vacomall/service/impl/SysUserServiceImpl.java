package com.vacomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vacomall.common.util.MD5;
import com.vacomall.entity.SysUser;
import com.vacomall.mapper.SysUserMapper;
import com.vacomall.service.ISysUserService;

/**
 *
 * SysUser 表数据服务层接口实现类
 *
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Autowired private SysUserMapper userMapper;

	@Override
	public SysUser login(SysUser sysUser) {
		// TODO Auto-generated method stub
		return this.selectOne(new EntityWrapper<SysUser>().eq("userName", sysUser.getUserName()).eq("password", MD5.toMD5(sysUser.getPassword())));
	}
}