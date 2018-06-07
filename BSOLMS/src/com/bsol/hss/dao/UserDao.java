package com.bsol.hss.dao;

import com.bsol.hss.bean.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * 查找用户
	 * @return
	 */
	public User findUserByName(String username);
	
	/**
	 * 通过用户ID修改用户密码
	 * @param userID
	 * @return
	 */
	public boolean updateUserById(int userID,String password);

}
