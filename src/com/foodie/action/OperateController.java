package com.foodie.action;

import java.util.HashMap;
import java.util.Map;

import com.foodie.model.Dish;
import com.foodie.model.Shop;
import com.foodie.model.User;
import com.foodie.util.StringUtil;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;

public class OperateController extends Controller {
	
	/**
	 * 点菜
	 */
	public void orderDish(){
		String dishOrder = getPara("dishOrder");
		String shopId = getPara("shopId");
		String[] dishArray = StringUtil.partString(dishOrder);
		double count = Dish.dishDao.getCount(dishArray, shopId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", count);
		renderJson(result);
	}
	/**
	 * 修改用户信息
	 */
	public void editInfoUser(){
		String userId = getPara("userId");
		String username = getPara("username");
		String address = getPara("statue");
		String phone = getPara("phone");
		User resultUser = User.userDao.updateInfo(userId, phone, address, username);
		Map<String,Object> result = new HashMap<String,Object>();
		
	}
	/**
	 * 修改店铺信息
	 */
	public void editInfoShop(){
		String shopId=getPara("shopId");
		String address=getPara("address");
		String shopName=getPara("shopName");
		Shop.shopDao.update(shopId, shopName, address);
		
	}
	/**
	 * 修改菜品信息
	 */
	public void editInfoDish(){
		String dishName = getPara("dishName");
		String price = getPara("price");
		String dishId = getPara("dishId");
		Dish resultDish = Dish.dishDao.updateDish(dishId, dishName, price);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "success");
		result.put("resultDish", resultDish);
		renderJson(result);
		resultDish=null;
	}
	/**
	 * 添加菜品
	 */
	public void addDish(){
		String dishName = getPara("dishName");
		String price = getPara("price");
		String shopId = getPara("shopId");
		String userId = getPara("userId");
	
		Dish dish = new Dish();
		dish.put("dishName",dishName);
		dish.put("price",price);
		dish.put("shopId",shopId);
		dish.put("userId",userId);
		dish.put("id","");
		dish.save();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "success");
		result.put("dish", dish);
		renderJson(result);
		dish = null;
	}
	/**
	 * 删除菜品
	 */
	public void deleteDish(){
		String dishId = getPara("dishId");
		Db.update("delete from dish where dishId=?",dishId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "success");
		renderJson(result);
	}
	/**
	 * 评论
	 */
	public void comment(){
		
	}
	/**
	 * 账单
	 */
	public void bill(){
		String dishOrder = getPara("dishOrder");
		String shopId = getPara("shopId");
		String[] dishArray = StringUtil.partString(dishOrder);
		double count = Dish.dishDao.getCount(dishArray, shopId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("count", count);
		for(String str:dishArray){
			result.put("dishName", str);
		}
		renderJson(result);
	}
	
	public void pay(){
		String shopId = getPara("shopId");
		String profit = getPara("profit");
		
	}
}
