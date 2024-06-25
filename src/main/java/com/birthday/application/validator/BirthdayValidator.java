package com.birthday.application.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.birthday.application.model.BirthdayRequest;
import com.birthday.application.service.BirthdayService;

@Component
public class BirthdayValidator {
	
	@Autowired
	private BirthdayService birthdayService;
	
	public ResponseEntity<Map<String,String>> validateRequest(final BirthdayRequest birthdayReq){
		
		Map<String, String> error = new HashMap<>();
		
		if(StringUtils.isEmpty(birthdayReq.getName()) || Objects.isNull(birthdayReq.getDate())) {
			error.put("error", "Invalid request");
			return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
		}
		
		try {
			return new ResponseEntity<Map<String,String>>(birthdayService.addBirthdate(birthdayReq),HttpStatus.OK);
		} catch (Exception e) {
			error.put("error", e.getMessage());
			return new ResponseEntity<Map<String,String>>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
