package com.liam.its_personnal.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.liam.its_personnal.model.IpUser;
import com.liam.its_personnal.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return IpUser.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		IpUser ipUser = (IpUser) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
		if (ipUser.getUserName().length() > 36) {
			errors.rejectValue("userName", "Size.userForm.userName");
		}
		if (!ipUser.getUserName().matches("\\w+")) {
			errors.rejectValue("userName", "Character.userForm.userName");
		}
		if (null != userService.findByUserName(ipUser.getUserName())) {
			errors.rejectValue("userName", "Duplicate.userForm.userName");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "NotEmpty");
		if (ipUser.getUserPw().length() < 8 || ipUser.getUserPw().length() > 32) {
			errors.rejectValue("userPw", "Size.userForm.password");
		}
		if (!ipUser.getUserPw().equals(ipUser.getUserPwConfirm())) {
			errors.rejectValue("userPwConfirm", "Diff.userForm.passwordConfirm");
		}
	}
}
