package com.foodie.config;
import com.foodie.action.ClientController;
import com.foodie.action.OperateController;
import com.foodie.model.Bill;
import com.foodie.model.Dish;
import com.foodie.model.FoodieComment;
import com.foodie.model.Picture;
import com.foodie.model.Profit;
import com.foodie.model.Shop;
import com.foodie.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;


public class MainConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants arg0) {
		// TODO Auto-generated method stub
		arg0.setDevMode(true);
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub
		loadPropertyFile("/db.properties");
		C3p0Plugin c3p0Plugin =new C3p0Plugin(getProperty("url"), getProperty("username"), getProperty("password"));
		arg0.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		arp.addMapping("user", User.class);
		arp.addMapping("shop", Shop.class);
		arp.addMapping("dish", Dish.class);
		arp.addMapping("bill", Bill.class);
		arp.addMapping("picture", Picture.class);
		arp.addMapping("profit", Profit.class);
		arp.addMapping("comment", FoodieComment.class);
		arg0.add(arp);
		
		
		
	}

	@Override
	public void configRoute(Routes arg0) {
		// TODO Auto-generated method stub
		arg0.add("/user", ClientController.class);
		arg0.add("/operate",OperateController.class);
	}

	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub
		
	}



	
	
	
}
