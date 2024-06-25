package com.birthday.application.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.birthday.application.repository.BirthdayRepository;

@Service
public class GetBirthDaysService {
	
	@Autowired
	BirthdayRepository birthdayRepository;
	
	public ResponseEntity<Map<String,Object>> getBirthdays() {
		try {
			return new ResponseEntity<Map<String,Object>>(getBirthdayList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Map<String,Object>>(Map.of("error", e),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public Map<String, Object> getBirthdayList() {
		return Map.of("birthdays", birthdayRepository.findAll());
	}

}
