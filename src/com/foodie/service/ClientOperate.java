package com.foodie.service;

import java.util.List;
import java.util.Map;

import com.foodie.model.Dish;
import com.foodie.model.User;

public interface ClientOperate {
	public User login(String username,String password);
	
	public Map<String,Object> update(User record);
	public Map<String,Object> orderDish(List<Dish> order);
}
