package com.birthday.application.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.birthday.application.model.BirthdayEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BirthdayReminderService {
	
	@Autowired
	private GetBirthDaysService getBirthdayService;
	
	@Scheduled(cron = "*/10 * * * * *")
    public void remindBirthday() {
		Map<String,List<BirthdayEntity>> birthdayList = new ObjectMapper()
				.convertValue(getBirthdayService.getBirthdayList(),  new TypeReference<Map<String,List<BirthdayEntity>>>() {});
		if (CollectionUtils.isNotEmpty(birthdayList.get("birthdays"))) {
			LocalDate today = LocalDate.now();
			SimpleDateFormat fmt = new SimpleDateFormat("MMdd");
			birthdayList.get("birthdays").stream()
					.filter(d -> fmt.format(Date.valueOf(today)).equals(fmt.format(d.getDate())))
					.forEach(b -> System.out.println("Happy Birthday! " + b.getName()));
		}
    }
}
