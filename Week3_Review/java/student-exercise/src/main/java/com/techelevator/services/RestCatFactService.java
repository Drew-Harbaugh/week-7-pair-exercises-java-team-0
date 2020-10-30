package com.techelevator.services;

import com.techelevator.model.CatPic;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			CatFact response = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random",
					CatFact.class);
			return response;
		} catch (ResourceAccessException | RestClientResponseException e) {
			return null;
		}
	}

}
