package com.stockMarket.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private List<ErrorInfo> errInfos;

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the errInfos
	 */
	public List<ErrorInfo> getErrInfos() {
		return errInfos;
	}

	/**
	 * @param errInfos the errInfos to set
	 */
	public void setErrInfos(List<ErrorInfo> errInfos) {
		this.errInfos = errInfos;
	}

}
