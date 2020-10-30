package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			CatPic response = restTemplate.getForObject("https://random-cat-image.herokuapp.com/",
					CatPic.class);
			return response;
		} catch (ResourceAccessException | RestClientResponseException e) {
			return null;
		}
	}

//	@Override
//	public CatPic getPic() {
//		CatPic result = new CatPic();
//		result.setFile("https://i.some-random-api.ml/NCgeBKe4og.jpg");
//		return result;
//	}

}	
