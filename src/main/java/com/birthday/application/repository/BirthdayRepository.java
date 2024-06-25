package com.birthday.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.birthday.application.model.BirthdayEntity;


@Repository
public interface BirthdayRepository extends JpaRepository<BirthdayEntity, Integer> {
	
}
