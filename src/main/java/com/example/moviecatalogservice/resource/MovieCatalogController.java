package com.example.moviecatalogservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.MovieInfo;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogForUser(@PathVariable("userId") String userId) {

		UserRatings ratings = restTemplate.getForObject("http://rating-service/ratingsdata/users/" + userId, UserRatings.class);
		return ratings.getRatings().stream().map(rating -> getCatalogItem(rating)).collect(Collectors.toList());
	}

	public CatalogItem getCatalogItem(Rating rating) {
		MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMoviId(),
				MovieInfo.class);
		CatalogItem catalogItem = new CatalogItem(movieInfo.getName(), movieInfo.getMovieId(), rating.getRating());
		return catalogItem;
	}

}
