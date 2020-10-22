package com.seckill.agent.validator;

import com.alibaba.druid.util.StringUtils;
import com.seckill.agent.service.impl.ValidationMobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lr-qixin
 * */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

	private boolean required = false;
	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required){
			return ValidationMobile.isMobile(value);
		}else{
			if(StringUtils.isEmpty(value)){
				return true;
			}else{
				return ValidationMobile.isMobile(value);
			}
		}
	}
	
	
	

}
