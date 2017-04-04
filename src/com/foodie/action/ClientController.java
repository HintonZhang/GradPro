package com.foodie.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.foodie.model.Shop;
import com.foodie.model.User;
import com.foodie.util.ControllerUtil;
import com.foodie.util.FileUtil;
import com.foodie.util.StringUtil;
import com.foodie.validator.TestValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.UploadFile;

import net.sf.json.JSONObject;

public class ClientController extends Controller{

	
	//声明用户操作对象
	
	public void index(){
		renderText("SUCCESS");
	}
	//登录
	/**
	 * param:list:商家列表
	 * param:userList:用户列表
	 */
	@Before(TestValidator.class)
	public void login(){
		String username = getPara("username");
		String password = getPara("password");
		String pageNumber = getPara("pageNumber");
		String pageSize = getPara("pageSize");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);
		if(StringUtil.isEmpty(username)){
			username = "";
		}
		if(StringUtil.isEmpty(password)){
			password = "";
		}
		//用户登录
		User resultU = User.userDao.login(username,password);
		Map<String,Object> result = new HashMap<String,Object>();
		if(resultU==null){
			result.put("result", "failed");
		}else{
			result.put("result", "successful");
			result.put("user", resultU);
			
			switch((String)resultU.get("type")){
				case "user":
					result.put("shopList", ControllerUtil.modelListToMapList(Shop.shopDao.getShopList(param).getList()));
					renderJson(result);
					
					break;
				case "admin":
					result.put("userList", ControllerUtil.modelListToMapList(User.userDao.adminUser(param).getList()));
					
					break;
			}
		}
		renderJson(result);
	}
	/**
	 * 用户注册
	 */
	public void register(){
		String username = getPara("username");
		String password = getPara("password");
		String phone = getPara("phone");
		String type = getPara("type");
		String userId = getPara("userId","");
		User user = new User();
		user.put("username",username);
		user.put("password",password);
		user.put("type",type);
		user.put("phone",phone);
		user.put("userId",userId);
		
		user.save();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "successful");
		result.put("user", user);
		
		renderJson(result);
		user = null;
	}
	/**
	 * 用户资格审核
	 */
	public void checkUser(){
		String judge = getPara("judge");
		String userId = getPara("userId");
		String pageNumber = getPara("pageNumber");
		String pageSize = getPara("pageSize");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("pageNumber", pageNumber);
		param.put("pageSize", pageSize);
		Db.update("update user set statue = ? where userId=?",judge,userId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "successful");
		result.put("userList", ControllerUtil.modelListToMapList(User.userDao.adminUser(param).getList()));
		renderJson(result);
	}
	/**
	 * 进入店铺
	 */
	public void intoShop(){
		String userId = getPara("userId");
		Shop shop = Shop.shopDao.search(userId);
		Map<String,Object> result = new HashMap<String,Object>();
		if(shop==null){
			result.put("resultCode", "failed");
		}else{
			result.put("result", "successful");
			result.put("shop",shop);
		}
		
		renderJson(result);
	}
	/**
	 * 商家入驻
	 */
	public void addShop(){
		
		String shopName = getPara("shopName");
		String userId = getPara("userId");
		String address = getPara("address");
		Shop shopSave = new Shop();
		
		shopSave.put("shopName",shopName);
		shopSave.put("userId",userId);
		shopSave.put("address",address);
		shopSave.put("id","");
		shopSave.save();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "successful");
		result.put("shopSave", shopSave);
		renderJson(result);
		shopSave = null;
	}
	
	public void test(){
		 UploadFile uploadFile=getFile("fileupload");

	        
	        String fileName=uploadFile.getOriginalFileName();
	        
	        
	        File file=uploadFile.getFile();    
	           
	        File t=new File("S:\\file\\"+fileName);
	        try {
	            t.createNewFile();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        FileUtil.fileChannelCopy(file, t);
	        file.delete();
	        this.renderHtml("success,<a href=\"./\">back</a>");
	    }
			
		
	
}
