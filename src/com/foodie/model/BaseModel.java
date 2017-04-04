package com.foodie.model;

import java.util.List;
import java.util.Map;

import com.foodie.util.StringUtil;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Table;
import com.jfinal.plugin.activerecord.TableMapping;


public class BaseModel<M extends BaseModel<M>> extends Model<M> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2787070448176433881L;
	/**
	 * 
	 */
	
	protected int pageSize = 20;
	
	/**
	 * 获取该对象的map映射
	 */
	public Map<String, Object> getAttrs() {
		return super.getAttrs();
	}
	
	public List<M> findAll(){
		Table table = TableMapping.me().getTable(getClass());
		String tableName =table.getName().toLowerCase();
		return find("select * from "+tableName);
	}
	
	public static boolean isNotEmpty(Object obj) {
		if (obj == null)
			return false;
		if ("".equals(String.valueOf(obj)))
			return false;
		return true;
	}
	
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if ("".equals(String.valueOf(obj)))
			return true;
		return false;
	}
	
	public String  getStr(String str) {
		return String.valueOf(get(str));
	}
	
	public String  getStr(String str, String value) {
		if (StringUtil.isEmpty(str)) {
			return String.valueOf(get(value));
		}
		
		return String.valueOf(get(str));
	}

	public Integer getInt(String attr) {
		if(getStr(attr)==null||"".equals(getStr(attr))||"null".equals(getStr(attr))){
			return 0;
		}else{
			return Integer.valueOf(getStr(attr));
		}
	}

	public Long getLong(String attr) {
		if(getStr(attr)==null||"".equals(getStr(attr))||"null".equals(getStr(attr))){
			return 0L;
		}else{
			return Long.valueOf(getStr(attr));
		}

	}
}
