/**
 * 
 */
package com.stockMarket.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.stockMarket.constants.ValidationMessages;

/**
 * @author User
 *
 */
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CurrCodeValidator.class})
@Documented
public @interface CurrCodeValidity {

	String message() default ValidationMessages.CURRENCY_CODE;
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
