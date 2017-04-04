package com.foodie.validator;



import com.foodie.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class TestValidator extends Validator {

	@Override
	protected void handleError(Controller arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void validate(Controller arg0) {
		// TODO Auto-generated method stub
		controller.keepModel(User.class);
		controller.render("NewFile.jsp");
	}

}
