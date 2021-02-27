package com.retail.shop.service;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.shop.entity.RetailShop;
import com.retail.shop.model.GenericResponseModel;
import com.retail.shop.repository.RetailShopsRepository;
import com.retail.shop.response.RetailResponse;

/**
 * @author Vivek_Singh
 *
 */

@Service
public class RetailShopService {

	@Autowired
	private RetailShopsRepository repository;

	@Autowired
	private RetailResponse responseAdapter;

	@Autowired
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * To save Shop detail into the DB
	 * @param shopDetails
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public ResponseEntity<GenericResponseModel<String>> saveShop(@Valid @RequestBody JSONObject shopDetails)
			throws JsonParseException, JsonMappingException, IOException {
		RetailShop shop = mapper.readValue(shopDetails.toString(), RetailShop.class);
		repository.save(shop);
		return responseAdapter.buildResponse("Shop Details Saved");
	}

	/**
	 * To extract all the shop details
	 * @return
	 */
	public ResponseEntity<GenericResponseModel<List<RetailShop>>> getShops() {
		return responseAdapter.buildResponse(repository.findAll());
	}

}
