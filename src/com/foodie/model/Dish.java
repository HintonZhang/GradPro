package com.foodie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.foodie.util.StringUtil;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

public class Dish extends BaseModel<Dish> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597408677248178966L;
	public static Dish dishDao = new Dish();
	public Page<Dish> getShopMenu(Map<String,Object> param){
		
		 StringBuffer select = new StringBuffer();
			select.append("select dishName,price,dishId ");
			StringBuffer sb = new StringBuffer();
			sb.append(" from dish  ");
			sb.append(" where shopId=? ");
			List<Object> paramList = new ArrayList<Object>();
			paramList.add(param.get("shopId"));
			int pageNumber = 1;
			int pageSize = 10;
			if(StringUtil.isNotEmpty(param.get("pageNumber"))){
				try {
					pageNumber = Integer.parseInt(param.get("pageNumber").toString());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			return paginate(pageNumber, pageSize, select.toString(), sb.toString(), paramList.toArray());
	}
	
	public Dish updateDish(String dishId,String dishName,String price){
		StringBuilder sql = new StringBuilder();
		double priceDouble;
		sql.append("update dish set ");
		if(StringUtil.isNotEmpty(dishName)){
			sql.append(" dishName=? and where dishId=?");
			Db.update(sql.toString(),dishName,dishId);
		}
		
		if(StringUtil.isNotEmpty(price)){
			sql.append("price=? where dishId=?");
			priceDouble = Double.parseDouble(price);
			Db.update(sql.toString(),priceDouble,dishId);
		}
		
		return selectDishById(dishId);
	}
	
	public Dish selectDishById(String dishId){
		String sql = "select dishName,dishPrice,dishId where dishId=?";
		return find(sql,dishId).get(0);
	}
	
	public double getCount(String[] dishArray,String shopId){
		String sql = "select price from dish where shopId=?";
		double result = 0.0;
		for(String dish:dishArray){
			result += Double.parseDouble(find(sql+" and dishName=?",shopId,dish).get(0).get("price").toString());
		}
		return result;
	}
	
	
}
