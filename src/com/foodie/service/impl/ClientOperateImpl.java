package com.foodie.service.impl;

import java.util.List;
import java.util.Map;

import com.foodie.model.Dish;
import com.foodie.model.User;
import com.foodie.service.ClientOperate;

public class ClientOperateImpl implements ClientOperate {
	
	public static ClientOperateImpl userOperate = new ClientOperateImpl();
	@Override
	public User login(String username,String password) {
		// TODO Auto-generated method stub
		User result = User.userDao.login(username,password);
		return result;
	}



	@Override
	public Map<String, Object> update(User record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> orderDish(List<Dish> order) {
		// TODO Auto-generated method stub
		return null;
	}

}
