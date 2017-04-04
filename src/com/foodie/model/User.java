package com.foodie.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.foodie.util.StringUtil;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

public class User extends BaseModel<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842761430810286247L;
	public static User userDao = new User();
	/**
	 * 
	 */
	public User updateInfo(String userId,String phone,String statue,String username){
		StringBuilder sql = new StringBuilder();
		sql.append("update user set");
		if(StringUtil.isNotEmpty(username)){
			sql.append(" username=? and where userId=?");
			Db.update(sql.toString(),username,userId);
		}
		if(StringUtil.isNotEmpty(phone)){
			sql.append(" phone=? and where userId=?");
			Db.update(sql.toString(),phone,userId);
		}
		
		if(StringUtil.isNotEmpty(statue)){
			sql.append(" statue=? and where userId=?");
			Db.update(sql.toString(),phone,statue);
		}
		
		
		return findById(userId);
	}
	
	public User findById(String userId){
		return find("select username,address,phone from user where userId=?",userId).get(0);
	}
	 public User login(String username,String password){
		 String sql = "select * from user where username=? and password=?";
		
		
		 return findFirst(sql,username,password);
	 }
	 
	 public Page<User> adminUser(Map<String,Object> param){
		 StringBuffer select = new StringBuffer();
			select.append("select userId,username,statue ");
			StringBuffer sb = new StringBuffer();
			sb.append(" from user  ");
			sb.append(" where type='user' and statue=1 ");
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
	 
	
}
