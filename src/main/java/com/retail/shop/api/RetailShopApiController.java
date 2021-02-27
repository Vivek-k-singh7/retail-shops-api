package com.retail.shop.api;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.retail.shop.entity.RetailShop;
import com.retail.shop.model.GenericResponseModel;
import com.retail.shop.service.RetailShopService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class RetailShopApiController {

	@Autowired
	private RetailShopService retailShopService;

	@PostMapping(value = "/save-shop", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GenericResponseModel<String>> saveShop(@Valid @RequestBody JSONObject shopDetails)
			throws JsonParseException, JsonMappingException, IOException {
		return retailShopService.saveShop(shopDetails);
	}

	@GetMapping(value = "/shops", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<GenericResponseModel<List<RetailShop>>> getShops() {
		return retailShopService.getShops();
	}
}
