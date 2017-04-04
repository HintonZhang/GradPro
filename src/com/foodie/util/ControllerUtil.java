package com.foodie.util;

import java.util.ArrayList;
import java.util.List;

import com.foodie.model.BaseModel;

public class ControllerUtil {
	public static List modelListToMapList(List<? extends BaseModel> list){
		
		List jsonList = new ArrayList();
		
		for(int i=0;i<list.size();i++){
			try {
				jsonList.add(list.get(i).getClass().getMethod("getAttrs",null).invoke(list.get(i)));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		
		return jsonList;
	}
}
