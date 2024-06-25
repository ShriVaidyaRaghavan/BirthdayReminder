package com.birthday.application.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birthday.application.model.BirthdayEntity;
import com.birthday.application.model.BirthdayRequest;
import com.birthday.application.repository.BirthdayRepository;

@Service
public class BirthdayService {
	
	@Autowired
	BirthdayRepository birthdayRepository;

	public Map<String, String> addBirthdate(BirthdayRequest birthdayReq) {
		BirthdayEntity birthday = new BirthdayEntity();
		birthday.setName(birthdayReq.getName());
		birthday.setDate(birthdayReq.getDate());
		return Map.of("added birthday",birthdayRepository.save(birthday).toString());
	}

}
