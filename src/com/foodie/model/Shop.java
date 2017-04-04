package com.foodie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.foodie.util.StringUtil;

public class Shop extends BaseModel<Shop> {

	/**
	 * 
	 */
	public static Shop shopDao = new Shop();
	private static final long serialVersionUID = -2252149402878384875L;
	public Page<Shop> getShopList(Map<String, Object> param){
		// 查询
		StringBuffer select = new StringBuffer();
		select.append("select shopId,shopName,address,userId ");
		StringBuffer sb = new StringBuffer();
		sb.append(" from shop  ");
		sb.append(" where 1=1 ");
		List<Object> paramList = new ArrayList<Object>();

		
		
		int pageNumber = 1;
		int pageSize = 10;
		if(StringUtil.isNotEmpty(param.get("pageNumber"))){
			try {
				pageNumber = Integer.parseInt(param.get("pageNumber").toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		if(StringUtil.isNotEmpty(param.get("pageSize"))){
			try {
				pageSize = Integer.parseInt(param.get("pageSize").toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		return paginate(pageNumber, pageSize, select.toString(), sb.toString(), paramList.toArray());
		
	}
	
	
	public Shop search(String userId){
		 
			 String sql = "select * from shop where userId=? ";
			
		 List<Shop> shopList =find(sql,userId);
			 Shop result = shopList.get(0);	
			 return result;
		 
	}
	
	public Shop update(String shopId,String shopName,String address){
		StringBuilder sql = new StringBuilder();
		sql.append("update shop set ");
		if(StringUtil.isNotEmpty(shopName)){
			sql.append("shopName=? where shopId=?");
			Db.update(sql.toString(),shopName,shopId);
		}
		
		if(StringUtil.isNotEmpty(address)){
			sql.append(" address=? where shopId=?");
			Db.update(sql.toString(),shopName,address);
		}
		
		return search(shopId);
	}
}
