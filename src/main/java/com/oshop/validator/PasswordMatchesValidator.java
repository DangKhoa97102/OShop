package com.oshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.oshop.dto.user.ChangePass;
import com.oshop.dto.user.Register;
import com.oshop.dto.user.ResetPass;
import com.oshop.validator.annotation.PasswordMatches;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {

		if (obj instanceof ResetPass resetPass) {
            if (resetPass.getPasswordConfirm().isBlank()) return true;
            return resetPass.getPassword().equals(resetPass.getPasswordConfirm());
        } else if (obj instanceof ChangePass changePass) {
            if (changePass.getNewPasswordConfirm().isBlank()) return true;
            return changePass.getNewPassword().equals(changePass.getNewPasswordConfirm());
        } else if (obj instanceof Register register) {
            if (register.getPasswordConfirm().isBlank()) return true;
            return register.getPassword().equals(register.getPasswordConfirm());
        }
        return true;
	}
}
