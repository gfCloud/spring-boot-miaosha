package com.miaosha.agent.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.alibaba.druid.util.StringUtils;
import com.miaosha.agent.service.impl.Validation_mobile;

public class IsmobileValidator implements ConstraintValidator<IsMobile,String> {

	private boolean required = false;
	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required){
			return Validation_mobile.isMobile(value);
		}else{
			if(StringUtils.isEmpty(value)){
				return true;
			}else{
				return Validation_mobile.isMobile(value);
			}
		}
	}
	
	
	

}
