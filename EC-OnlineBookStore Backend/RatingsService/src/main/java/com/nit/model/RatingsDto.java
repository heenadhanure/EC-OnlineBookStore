package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingsDto {
	
	private Long cusmerId;
	private Long bookId;
	private int rate;
	private String reviewText;

}
