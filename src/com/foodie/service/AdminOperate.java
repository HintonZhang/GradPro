package com.foodie.service;

import java.util.List;

import com.foodie.model.Bill;
import com.foodie.model.Shop;
import com.foodie.model.User;

public interface AdminOperate {
	public List<User> queryUserList();
	public List<Shop> queryShopList();
	public List<Bill> queryBillList();
	public String updateUserInfo(User user);
	public String updateShopInfo(Shop shop);
	public String updateBillInfo(Bill bill);
}
