package com.ibm.ojt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

	@Override
	public LocalDateTime convert(String dateToConvert) {
		System.out.println("--NIAGI KO DIRI--");
		Date _dateToConvert = null;
		try {
			_dateToConvert = new SimpleDateFormat("yyyy-MM-dd").parse(dateToConvert);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return _dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
