package com.cro.service;

import com.cro.entity.User;

public interface ILoginService {
	public User login(String username,String password);
	public int updateUsertookenById(Integer id, String tooken);
	public User finUserBytooken(String tooken);
}
 