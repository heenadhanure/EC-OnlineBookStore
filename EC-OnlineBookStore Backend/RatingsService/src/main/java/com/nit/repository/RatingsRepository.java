package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Long>{

}
