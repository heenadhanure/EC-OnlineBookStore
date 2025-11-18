package com.nit.service;

import java.util.List;

import com.nit.entity.Ratings;
import com.nit.model.RatingsDto;

public interface RatingsService {

	Ratings createRatingRivews(RatingsDto ratingsDto);

	List<Ratings> getByAllReview();

}
