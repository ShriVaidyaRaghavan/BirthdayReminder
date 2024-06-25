package com.birthday.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birthday.application.model.BirthdayRequest;
import com.birthday.application.service.GetBirthDaysService;
import com.birthday.application.validator.BirthdayValidator;


@RestController
@RequestMapping("/api/v1")
public class BirthdayController {
	
	@Autowired
	private BirthdayValidator birthday;
	
	@Autowired
	private GetBirthDaysService getBirthdayService;
	
	@PostMapping("/birthDay")
	public ResponseEntity<Map<String,String>> addBirthday(@RequestBody BirthdayRequest birthdayRequest){
		return birthday.validateRequest(birthdayRequest);
	}
	
	@GetMapping("/birthDay")
	public ResponseEntity<Map<String,Object>> getBirthdays(){
		return getBirthdayService.getBirthdays();
	}

}
