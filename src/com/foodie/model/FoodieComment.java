package com.foodie.model;

import com.jfinal.plugin.activerecord.Model;

public class FoodieComment extends Model<FoodieComment> {
	public static FoodieComment commentDao = new FoodieComment();
}
