package com.stockMarket.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class CurrCodeValidator implements ConstraintValidator<CurrCodeValidity, String> {

	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		return !(StringUtils.isEmpty(code) || code.length() != 3);
	}

}
