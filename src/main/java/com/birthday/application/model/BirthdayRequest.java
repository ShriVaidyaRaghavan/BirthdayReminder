package com.birthday.application.model;

import java.sql.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BirthdayRequest {
	
	int id;
	
	String name;
	
	Date date;

}
