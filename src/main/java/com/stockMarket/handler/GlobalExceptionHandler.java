/**
 * 
 */
package com.stockMarket.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.stockMarket.model.ApiError;
import com.stockMarket.model.ErrorInfo;

/**
 * @author User
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public ApiError argumentNotValidExcHandler(MethodArgumentNotValidException exception) {
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		List<ErrorInfo> errList = Lists.newArrayList();
		exception.getFieldErrors().forEach(error-> {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setField(error.getField());
			errorInfo.setMessage(error.getDefaultMessage());
			errList.add(errorInfo);
		});
		apiError.setErrInfos(errList);
		return apiError;
	}

}
