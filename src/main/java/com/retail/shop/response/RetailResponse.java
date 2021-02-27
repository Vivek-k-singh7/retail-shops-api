package com.retail.shop.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retail.shop.model.GenericResponseModel;


@Service
public class RetailResponse {
	/**
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public <T> ResponseEntity<GenericResponseModel<T>> buildResponse(T response) {
		GenericResponseModel<T> response200 = new GenericResponseModel<>();
		response200.setResponseBody(response);
		return new ResponseEntity<>(response200, HttpStatus.OK);
	}

	/**
	 * @param statusCode
	 */
	public void throwException(HttpStatus status) throws Exception {
		if (!HttpStatus.OK.equals(status))
			throw new Exception("INTERNAL_SERVER_ERROR, An unexpected internal server error occured");
	}
}
